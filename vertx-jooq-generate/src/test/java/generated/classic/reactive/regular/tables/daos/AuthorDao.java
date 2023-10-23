/*
 * This file is generated by jOOQ.
 */
package generated.classic.reactive.regular.tables.daos;


import generated.classic.reactive.regular.tables.Author;
import generated.classic.reactive.regular.tables.records.AuthorRecord;

import io.github.jklingsporn.vertx.jooq.shared.reactive.AbstractReactiveVertxDAO;

import java.util.Collection;

import org.jooq.Configuration;


import java.util.List;
import io.vertx.core.Future;
import io.github.jklingsporn.vertx.jooq.classic.reactivepg.ReactiveClassicQueryExecutor;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AuthorDao extends AbstractReactiveVertxDAO<AuthorRecord, generated.classic.reactive.regular.tables.pojos.Author, Integer, Future<List<generated.classic.reactive.regular.tables.pojos.Author>>, Future<generated.classic.reactive.regular.tables.pojos.Author>, Future<Integer>, Future<Integer>> implements io.github.jklingsporn.vertx.jooq.classic.VertxDAO<AuthorRecord,generated.classic.reactive.regular.tables.pojos.Author,Integer> {

        /**
     * @param configuration Used for rendering, so only SQLDialect must be set
     * and must be one of the POSTGREs types.
     * @param delegate A configured AsyncSQLClient that is used for query
     * execution
     */
        public AuthorDao(Configuration configuration, io.vertx.sqlclient.SqlClient delegate) {
                super(Author.AUTHOR, generated.classic.reactive.regular.tables.pojos.Author.class, new ReactiveClassicQueryExecutor<AuthorRecord,generated.classic.reactive.regular.tables.pojos.Author,Integer>(configuration,delegate,generated.classic.reactive.regular.tables.mappers.RowMappers.getAuthorMapper()));
        }

        @Override
        protected Integer getId(generated.classic.reactive.regular.tables.pojos.Author object) {
                return object.getId();
        }

        /**
     * Find records that have <code>name IN (values)</code> asynchronously
     */
        public Future<List<generated.classic.reactive.regular.tables.pojos.Author>> findManyByName(Collection<String> values) {
                return findManyByCondition(Author.AUTHOR.NAME.in(values));
        }

        /**
     * Find records that have <code>name IN (values)</code> asynchronously
     * limited by the given limit
     */
        public Future<List<generated.classic.reactive.regular.tables.pojos.Author>> findManyByName(Collection<String> values, int limit) {
                return findManyByCondition(Author.AUTHOR.NAME.in(values),limit);
        }

        @Override
        public ReactiveClassicQueryExecutor<AuthorRecord,generated.classic.reactive.regular.tables.pojos.Author,Integer> queryExecutor(){
                return (ReactiveClassicQueryExecutor<AuthorRecord,generated.classic.reactive.regular.tables.pojos.Author,Integer>) super.queryExecutor();
        }
}
