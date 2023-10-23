/*
 * This file is generated by jOOQ.
 */
package generated.classic.r2dbc.regular.tables.daos;


import generated.classic.r2dbc.regular.tables.Somethingwithoutjson;
import generated.classic.r2dbc.regular.tables.records.SomethingwithoutjsonRecord;

import io.github.jklingsporn.vertx.jooq.shared.internal.AbstractVertxDAO;

import java.util.Collection;

import org.jooq.Configuration;


import java.util.List;
import io.vertx.core.Future;
import io.github.jklingsporn.vertx.jooq.classic.r2dbc.R2dbcClassicQueryExecutor;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SomethingwithoutjsonDao extends AbstractVertxDAO<SomethingwithoutjsonRecord, generated.classic.r2dbc.regular.tables.pojos.Somethingwithoutjson, Integer, Future<List<generated.classic.r2dbc.regular.tables.pojos.Somethingwithoutjson>>, Future<generated.classic.r2dbc.regular.tables.pojos.Somethingwithoutjson>, Future<Integer>, Future<Integer>> implements io.github.jklingsporn.vertx.jooq.classic.VertxDAO<SomethingwithoutjsonRecord,generated.classic.r2dbc.regular.tables.pojos.Somethingwithoutjson,Integer> {

        /**
     * @param configuration Used for rendering, so only SQLDialect must be set
     * and must be one of the POSTGREs types.
     * @param delegate A configured AsyncSQLClient that is used for query
     * execution
     */
        public SomethingwithoutjsonDao(Configuration configuration) {
                super(Somethingwithoutjson.SOMETHINGWITHOUTJSON, generated.classic.r2dbc.regular.tables.pojos.Somethingwithoutjson.class, new R2dbcClassicQueryExecutor<SomethingwithoutjsonRecord,generated.classic.r2dbc.regular.tables.pojos.Somethingwithoutjson,Integer>(configuration,generated.classic.r2dbc.regular.tables.pojos.Somethingwithoutjson.class, generated.classic.r2dbc.regular.tables.pojos.Somethingwithoutjson::new));
        }

        @Override
        protected Integer getId(generated.classic.r2dbc.regular.tables.pojos.Somethingwithoutjson object) {
                return object.getSomeid();
        }

        /**
     * Find records that have <code>someString IN (values)</code> asynchronously
     */
        public Future<List<generated.classic.r2dbc.regular.tables.pojos.Somethingwithoutjson>> findManyBySomestring(Collection<String> values) {
                return findManyByCondition(Somethingwithoutjson.SOMETHINGWITHOUTJSON.SOMESTRING.in(values));
        }

        /**
     * Find records that have <code>someString IN (values)</code> asynchronously
     * limited by the given limit
     */
        public Future<List<generated.classic.r2dbc.regular.tables.pojos.Somethingwithoutjson>> findManyBySomestring(Collection<String> values, int limit) {
                return findManyByCondition(Somethingwithoutjson.SOMETHINGWITHOUTJSON.SOMESTRING.in(values),limit);
        }

        @Override
        public R2dbcClassicQueryExecutor<SomethingwithoutjsonRecord,generated.classic.r2dbc.regular.tables.pojos.Somethingwithoutjson,Integer> queryExecutor(){
                return (R2dbcClassicQueryExecutor<SomethingwithoutjsonRecord,generated.classic.r2dbc.regular.tables.pojos.Somethingwithoutjson,Integer>) super.queryExecutor();
        }
}
