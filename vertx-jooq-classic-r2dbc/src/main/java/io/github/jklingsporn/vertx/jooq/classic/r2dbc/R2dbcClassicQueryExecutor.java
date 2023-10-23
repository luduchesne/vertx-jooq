package io.github.jklingsporn.vertx.jooq.classic.r2dbc;

import io.github.jklingsporn.vertx.jooq.classic.VertxDAO;
import io.github.jklingsporn.vertx.jooq.shared.internal.QueryExecutor;
import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;
import io.vertx.core.Future;
import io.vertx.core.Vertx;

import org.jooq.*;
import org.jooq.Record;

import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by jensklingsporn on 01.03.18.
 */
public class R2dbcClassicQueryExecutor<R extends UpdatableRecord<R>,P extends VertxPojo,T> extends R2dbcClassicGenericQueryExecutor implements QueryExecutor<R,T,Future<List<P>>,Future<P>,Future<Integer>,Future<T>> {

    private final Class<P> daoType;

    private final Function<R,P> constructor;

    public R2dbcClassicQueryExecutor(Configuration configuration, Class<P> daoType,Function<R,P> constructor) {
        super(configuration);
        this.daoType = daoType;
        this.constructor =constructor;
    }

    @Override
    public Future<List<P>> findMany(Function<DSLContext, ? extends ResultQuery<R>> queryFunction) {
        return executeMany(queryFunction)
                       .map(r -> r.stream()
                                         .map(constructor)
                                         .collect(Collectors.toList()));

    }

    @Override
    public Future<P> findOne(Function<DSLContext, ? extends ResultQuery<R>> queryFunction) {
        return  executeAny(queryFunction)
                        .map(res -> {
                            if(res ==null){
                                return null;
                            }
                            return constructor.apply(res);
                                }

                        );
    }

    @Override
    public Future<T> insertReturning(Function<DSLContext, ? extends InsertResultStep<R>> queryFunction, Function<Object, T> keyMapper) {
        return executeAny(queryFunction)
                       .map(r ->{
                           Objects.requireNonNull(r, () -> "Failed inserting record or no key");
                           Record key1 = r.key();
                           if(key1.size() == 1){
                               T value = ((Record1<T>) key1).value1();
                               return value == null ?  (T)r.get(0) : ((Record1<T>)key1).value1();
                           }
                           return (T) key1;
                       });
    }

}
