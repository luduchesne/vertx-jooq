/*
 * This file is generated by jOOQ.
 */
package generated.mutiny.reactive.guice.tables.daos;


import generated.mutiny.reactive.guice.tables.Author;
import generated.mutiny.reactive.guice.tables.records.AuthorRecord;

import io.github.jklingsporn.vertx.jooq.shared.reactive.AbstractReactiveVertxDAO;

import java.util.Collection;

import org.jooq.Configuration;


import java.util.List;
import io.smallrye.mutiny.Uni;
import io.github.jklingsporn.vertx.jooq.mutiny.reactive.ReactiveMutinyQueryExecutor;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@javax.inject.Singleton
public class AuthorDao extends AbstractReactiveVertxDAO<AuthorRecord, generated.mutiny.reactive.guice.tables.pojos.Author, Integer, Uni<List<generated.mutiny.reactive.guice.tables.pojos.Author>>, Uni<generated.mutiny.reactive.guice.tables.pojos.Author>, Uni<Integer>, Uni<Integer>> implements io.github.jklingsporn.vertx.jooq.mutiny.VertxDAO<AuthorRecord,generated.mutiny.reactive.guice.tables.pojos.Author,Integer> {
        @javax.inject.Inject

        /**
     * @param configuration The Configuration used for rendering and query
     * execution.
     * @param vertx the vertx instance
     */
        public AuthorDao(Configuration configuration, io.vertx.mutiny.sqlclient.SqlClient delegate) {
                super(Author.AUTHOR, generated.mutiny.reactive.guice.tables.pojos.Author.class, new ReactiveMutinyQueryExecutor<AuthorRecord,generated.mutiny.reactive.guice.tables.pojos.Author,Integer>(configuration,delegate,generated.mutiny.reactive.guice.tables.mappers.RowMappers.getAuthorMapper()));
        }

        @Override
        protected Integer getId(generated.mutiny.reactive.guice.tables.pojos.Author object) {
                return object.getId();
        }

        /**
     * Find records that have <code>name IN (values)</code> asynchronously
     */
        public Uni<List<generated.mutiny.reactive.guice.tables.pojos.Author>> findManyByName(Collection<String> values) {
                return findManyByCondition(Author.AUTHOR.NAME.in(values));
        }

        /**
     * Find records that have <code>name IN (values)</code> asynchronously
     * limited by the given limit
     */
        public Uni<List<generated.mutiny.reactive.guice.tables.pojos.Author>> findManyByName(Collection<String> values, int limit) {
                return findManyByCondition(Author.AUTHOR.NAME.in(values),limit);
        }

        @Override
        public ReactiveMutinyQueryExecutor<AuthorRecord,generated.mutiny.reactive.guice.tables.pojos.Author,Integer> queryExecutor(){
                return (ReactiveMutinyQueryExecutor<AuthorRecord,generated.mutiny.reactive.guice.tables.pojos.Author,Integer>) super.queryExecutor();
        }
}
