/*
 * This file is generated by jOOQ.
 */
package generated.rx.reactive.guice.tables.daos;


import generated.rx.reactive.guice.tables.Somethingwithoutjson;
import generated.rx.reactive.guice.tables.records.SomethingwithoutjsonRecord;

import io.github.jklingsporn.vertx.jooq.shared.reactive.AbstractReactiveVertxDAO;

import java.util.Collection;

import org.jooq.Configuration;


import java.util.List;
import io.reactivex.Single;
import java.util.Optional;
import io.github.jklingsporn.vertx.jooq.rx.reactivepg.ReactiveRXQueryExecutor;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@javax.inject.Singleton
public class SomethingwithoutjsonDao extends AbstractReactiveVertxDAO<SomethingwithoutjsonRecord, generated.rx.reactive.guice.tables.pojos.Somethingwithoutjson, Integer, Single<List<generated.rx.reactive.guice.tables.pojos.Somethingwithoutjson>>, Single<Optional<generated.rx.reactive.guice.tables.pojos.Somethingwithoutjson>>, Single<Integer>, Single<Integer>> implements io.github.jklingsporn.vertx.jooq.rx.VertxDAO<SomethingwithoutjsonRecord,generated.rx.reactive.guice.tables.pojos.Somethingwithoutjson,Integer> {
    @javax.inject.Inject

    /**
     * @param configuration The Configuration used for rendering and query execution.
     * @param vertx the vertx instance
     */
    public SomethingwithoutjsonDao(Configuration configuration, io.vertx.reactivex.sqlclient.SqlClient delegate) {
        super(Somethingwithoutjson.SOMETHINGWITHOUTJSON, generated.rx.reactive.guice.tables.pojos.Somethingwithoutjson.class, new ReactiveRXQueryExecutor<SomethingwithoutjsonRecord,generated.rx.reactive.guice.tables.pojos.Somethingwithoutjson,Integer>(configuration,delegate,generated.rx.reactive.guice.tables.mappers.RowMappers.getSomethingwithoutjsonMapper()));
    }

    @Override
    protected Integer getId(generated.rx.reactive.guice.tables.pojos.Somethingwithoutjson object) {
        return object.getSomeid();
    }

    /**
     * Find records that have <code>someString IN (values)</code> asynchronously
     */
    public Single<List<generated.rx.reactive.guice.tables.pojos.Somethingwithoutjson>> findManyBySomestring(Collection<String> values) {
        return findManyByCondition(Somethingwithoutjson.SOMETHINGWITHOUTJSON.SOMESTRING.in(values));
    }

    /**
     * Find records that have <code>someString IN (values)</code> asynchronously limited by the given limit
     */
    public Single<List<generated.rx.reactive.guice.tables.pojos.Somethingwithoutjson>> findManyBySomestring(Collection<String> values, int limit) {
        return findManyByCondition(Somethingwithoutjson.SOMETHINGWITHOUTJSON.SOMESTRING.in(values),limit);
    }

    @Override
    public ReactiveRXQueryExecutor<SomethingwithoutjsonRecord,generated.rx.reactive.guice.tables.pojos.Somethingwithoutjson,Integer> queryExecutor(){
        return (ReactiveRXQueryExecutor<SomethingwithoutjsonRecord,generated.rx.reactive.guice.tables.pojos.Somethingwithoutjson,Integer>) super.queryExecutor();
    }
}
