package io.github.jklingsporn.vertx.jooq.classic.r2dbc;

import io.github.jklingsporn.vertx.jooq.classic.ClassicQueryExecutor;
import io.github.jklingsporn.vertx.jooq.shared.internal.AbstractQueryExecutor;
import io.github.jklingsporn.vertx.jooq.shared.internal.QueryResult;
import io.r2dbc.spi.Connection;
import io.reactivex.rxjava3.core.Single;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

import org.jooq.Query;
import org.jooq.*;
import org.jooq.Record;
import org.jooq.conf.ParamType;
import org.jooq.impl.DSL;

import java.util.List;
import java.util.function.Function;

/**
 * Created by jensklingsporn on 01.03.18.
 */
public class R2dbcClassicGenericQueryExecutor extends AbstractQueryExecutor implements ClassicQueryExecutor {

  protected static final Logger LOGGER = LoggerFactory.getLogger(R2dbcClassicGenericQueryExecutor.class);

  protected final Connection connection;

  public R2dbcClassicGenericQueryExecutor(Configuration configuration) {
    this(configuration, null);
  }

  public R2dbcClassicGenericQueryExecutor(Configuration configuration, Connection connection) {
    super(configuration);
    this.connection = connection;
  }

  public <X> Future<X> findOneRow(Function<DSLContext, ? extends Publisher<X>> queryFunction) {
    return executeAny(queryFunction);
  }


  /**
   * Executes the given queryFunction and returns a <code>RowSet</code>
   *
   * @param queryFunction the query to execute
   * @return the results, never null
   */
  public <X> Future<List<X>> executeMany(Function<DSLContext, ? extends Publisher<X>> queryFunction) {
    try {
      return getConnection()
                     .flatMap(connection ->
                                      SingleHelper.flowToFuture(queryFunction.apply(DSL.using(connection)))
                                              .onComplete(ign ->
                                                                  closeIfNeed(connection)));
    } catch (Throwable e) {
      return Future.failedFuture(e);
    }
  }

  /**
   * Executes the given queryFunction and returns a <code>RowSet</code>
   *
   * @param queryFunction the query to execute
   * @return the results, never null
   */
  public <X> Future<X> executeAny(Function<DSLContext, ? extends Publisher<X>> queryFunction) {
    try {
      return getConnection()
                     .flatMap(connection ->
                        SingleHelper.maybeToFuture(queryFunction.apply(DSL.using(connection)))
                                .onComplete(ign ->
                                                    closeIfNeed(connection))
                     );
    } catch (Throwable e) {
      return Future.failedFuture(e);
    }
  }

  public Future<Integer> execute(Function<DSLContext, ? extends Query> queryFunction) {
    try {
      return getConnection()
                     .flatMap(connection -> {
                       Query query = queryFunction.apply(DSL.using(connection));
                       log(query);
                       if (query instanceof Publisher) {
                         return SingleHelper.toFuture((Publisher<Integer>) query)
                                        .onComplete(ign ->
                                                            closeIfNeed(connection));
                       } else {
                         return Future.failedFuture("cannot execute because query isn't publisher");
                       }
                     });

    } catch (Throwable e) {
      return Future.failedFuture(e);
    }
  }

  protected void log(Query query) {
    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("Executing {}", query.getSQL(ParamType.INLINED));
    }
  }

  @Override
  public <R extends Record> Future<QueryResult> query(Function<DSLContext, ? extends ResultQuery<R>> queryFunction) {
    try {
      return getConnection()
                     .flatMap(connection ->  SingleHelper.flowToFuture(queryFunction.apply(DSL.using(connection)))
                               .map(list -> {
                                    if(list.isEmpty()){
                                      return  new R2DBCQueryResult(null);
                                    }
                                    else if(list.size() == 1){
                                      return new R2DBCQueryResult(list.get(0));
                                    }
                                    else{
                                      return  new R2DBCQueryResult(list, list.size());
                                    }
                               })
                     );
    } catch (Throwable e) {
      return Future.failedFuture(e);
    }
  }

  protected void closeIfNeed(Connection currentConnection){
    if(this.connection == null){
      SingleHelper.voidToFuture(currentConnection.close()) ;
    }
  }

  protected Future<? extends  Connection> getConnection() {

    if (connection!=null) {
      return Future.succeededFuture(connection);
    } else {
      return delegateAsPool();
    }
  }

  public Future<? extends R2dbcClassicGenericQueryExecutor> beginTransaction() {
    if (connection!=null) {
      return Future.failedFuture(new IllegalStateException("Already in transaction"));
    }
    return delegateAsPool()
                   .compose(conn -> SingleHelper.voidToFuture(conn.beginTransaction())
                                            .map(newInstance(conn)));
  }

  public <U> Future<U> transaction(Function<R2dbcClassicGenericQueryExecutor, Future<U>> transaction) {
    return beginTransaction()
                   .compose(queryExecutor -> transaction.apply(queryExecutor) //perform user tasks
                                                     .compose(
                                                             //commit the transaction if everything went fine and return the result
                                                             res -> queryExecutor.commit().map(v -> res),
                                                             //if not already rolled back, rollback the transaction and return the causing error
                                                             err -> {
                                                               //  if (err instanceof TransactionRollbackException) {
                                                               //  return Future.failedFuture(err);
                                                               //} else {
                                                               return queryExecutor
                                                                              .rollback()
                                                                              .compose(v -> Future.failedFuture(err), failure -> Future.failedFuture(err));
                                                               // }
                                                             }
                                                     )
                   );
  }

  protected Function<Void, ? extends R2dbcClassicGenericQueryExecutor> newInstance(Connection connection) {
    return transaction -> new R2dbcClassicGenericQueryExecutor(configuration(), connection);
  }

  protected Future<? extends  Connection> delegateAsPool() {
    if (configuration()==null) {
      return Future.failedFuture(new IllegalStateException("No configuration for db connection ??"));
    }


    return SingleHelper.toFuture(configuration().connectionFactory()
                                                 .create());
  }

  /**
   * Commits a transaction.
   *
   * @return a <code>Future</code> that completes when the transaction has been committed.
   * @throws IllegalStateException if not called <code>beginTransaction</code> before.
   */
  public Future<Void> commit() {
    if (connection==null) {
      return Future.failedFuture(new IllegalStateException("Not in transaction"));
    }
    return SingleHelper.voidToFuture(connection.commitTransaction())
                   .flatMap(res -> closeConnection(connection));
  }

  protected  Future<Void> closeConnection(Connection connection){
   return  SingleHelper.voidToFuture(connection.close());
  }

  /**
   * Rolls a transaction back.
   *
   * @return a <code>Future</code> that completes when the transaction has been rolled back.
   * @throws IllegalStateException if not called <code>beginTransaction</code> before.
   */
  public Future<Void> rollback() {
    if (connection==null) {
      return Future.failedFuture(new IllegalStateException("Not in transaction"));
    }
    return SingleHelper.voidToFuture(connection.rollbackTransaction())
                                           .flatMap(res -> closeConnection(connection));
  }
}
