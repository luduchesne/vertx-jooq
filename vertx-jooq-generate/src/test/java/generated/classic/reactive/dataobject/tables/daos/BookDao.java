/*
 * This file is generated by jOOQ.
 */
package generated.classic.reactive.dataobject.tables.daos;


import generated.classic.reactive.dataobject.tables.Book;
import generated.classic.reactive.dataobject.tables.records.BookRecord;

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
public class BookDao extends AbstractReactiveVertxDAO<BookRecord, generated.classic.reactive.dataobject.tables.pojos.Book, Integer, Future<List<generated.classic.reactive.dataobject.tables.pojos.Book>>, Future<generated.classic.reactive.dataobject.tables.pojos.Book>, Future<Integer>, Future<Integer>> implements io.github.jklingsporn.vertx.jooq.classic.VertxDAO<BookRecord,generated.classic.reactive.dataobject.tables.pojos.Book,Integer> {

        /**
     * @param configuration Used for rendering, so only SQLDialect must be set
     * and must be one of the POSTGREs types.
     * @param delegate A configured AsyncSQLClient that is used for query
     * execution
     */
        public BookDao(Configuration configuration, io.vertx.sqlclient.SqlClient delegate) {
                super(Book.BOOK, generated.classic.reactive.dataobject.tables.pojos.Book.class, new ReactiveClassicQueryExecutor<BookRecord,generated.classic.reactive.dataobject.tables.pojos.Book,Integer>(configuration,delegate,generated.classic.reactive.dataobject.tables.mappers.RowMappers.getBookMapper()));
        }

        @Override
        protected Integer getId(generated.classic.reactive.dataobject.tables.pojos.Book object) {
                return object.getId();
        }

        /**
     * Find records that have <code>label IN (values)</code> asynchronously
     */
        public Future<List<generated.classic.reactive.dataobject.tables.pojos.Book>> findManyByLabel(Collection<String> values) {
                return findManyByCondition(Book.BOOK.LABEL.in(values));
        }

        /**
     * Find records that have <code>label IN (values)</code> asynchronously
     * limited by the given limit
     */
        public Future<List<generated.classic.reactive.dataobject.tables.pojos.Book>> findManyByLabel(Collection<String> values, int limit) {
                return findManyByCondition(Book.BOOK.LABEL.in(values),limit);
        }

        /**
     * Find records that have <code>long_Field IN (values)</code> asynchronously
     */
        public Future<List<generated.classic.reactive.dataobject.tables.pojos.Book>> findManyByLongField(Collection<Long> values) {
                return findManyByCondition(Book.BOOK.LONG_FIELD.in(values));
        }

        /**
     * Find records that have <code>long_Field IN (values)</code> asynchronously
     * limited by the given limit
     */
        public Future<List<generated.classic.reactive.dataobject.tables.pojos.Book>> findManyByLongField(Collection<Long> values, int limit) {
                return findManyByCondition(Book.BOOK.LONG_FIELD.in(values),limit);
        }

        /**
     * Find records that have <code>author_id IN (values)</code> asynchronously
     */
        public Future<List<generated.classic.reactive.dataobject.tables.pojos.Book>> findManyByAuthorId(Collection<Integer> values) {
                return findManyByCondition(Book.BOOK.AUTHOR_ID.in(values));
        }

        /**
     * Find records that have <code>author_id IN (values)</code> asynchronously
     * limited by the given limit
     */
        public Future<List<generated.classic.reactive.dataobject.tables.pojos.Book>> findManyByAuthorId(Collection<Integer> values, int limit) {
                return findManyByCondition(Book.BOOK.AUTHOR_ID.in(values),limit);
        }

        @Override
        public ReactiveClassicQueryExecutor<BookRecord,generated.classic.reactive.dataobject.tables.pojos.Book,Integer> queryExecutor(){
                return (ReactiveClassicQueryExecutor<BookRecord,generated.classic.reactive.dataobject.tables.pojos.Book,Integer>) super.queryExecutor();
        }
}
