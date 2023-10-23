package io.github.jklingsporn.vertx.jooq.generate.classic.r2dbc.regular;

import org.jooq.Condition;
import org.jooq.Record2;
import org.jooq.Result;
import org.jooq.impl.DSL;
import org.jooq.meta.jaxb.Configuration;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

import generated.classic.r2dbc.regular.Tables;
import generated.classic.r2dbc.regular.tables.daos.AuthorDao;
import generated.classic.r2dbc.regular.tables.daos.BookDao;
import generated.classic.r2dbc.regular.tables.pojos.Author;
import generated.classic.r2dbc.regular.tables.pojos.Book;
import generated.classic.r2dbc.regular.tables.records.AuthorRecord;
import io.github.jklingsporn.vertx.jooq.generate.PostgresConfigurationProvider;
import io.github.jklingsporn.vertx.jooq.generate.ReactiveDatabaseClientProvider;
import io.github.jklingsporn.vertx.jooq.generate.VertxGeneratorStrategy;
import io.github.jklingsporn.vertx.jooq.generate.classic.ClassicTestBase;
import io.github.jklingsporn.vertx.jooq.generate.converter.BookConverter;

/**
 * Created by jensklingsporn on 02.11.16.
 */
public class BookDaoTest extends ClassicTestBase<Book, Integer, Long, BookDao> {

  AuthorDao authorDao = new AuthorDao(PostgresConfigurationProvider.getInstance().createDAOR2dbcConfiguration());

    public BookDaoTest() {
        super(Tables.BOOK.LONG_FIELD, new BookDao(PostgresConfigurationProvider.getInstance().createDAOR2dbcConfiguration()));
    }

    @BeforeClass
    public static void beforeClass() throws Exception {
        PostgresConfigurationProvider.getInstance().setupDatabase();
    }


  @Override
  protected Book create() {
    return createWithId();
  }

  @Override
  protected Book createWithId() {
    Random random = new Random();
    return new Book()
                   .setId(random.nextInt())
                   .setAuthorId(10)
                   .setLabel("my title");
  }

  @Override
  protected Book setId(Book pojo, Integer id) {
    return pojo.setId(id);
  }

  @Override
  protected Book setSomeO(Book pojo, Long someO) {
    return pojo.setLongField(someO);
  }

  @Override
  protected Integer getId(Book pojo) {
    return pojo.getId();
  }

  @Override
  protected Long createSomeO() {
    return null;
  }

  @Override
  protected Condition eqPrimaryKey(Integer id) {
    return null;
  }

  @Override
  protected void assertDuplicateKeyException(Throwable x) {

  }

  @Test
    public void containsShouldSucceed() throws InterruptedException {
        //https://github.com/jklingsporn/vertx-jooq/issues/93
        CountDownLatch latch = new CountDownLatch(1);

    authorDao.insertReturningPrimary(new Author().setId(15).setName("my author"))
            .compose(idAuthor ->
        insertAndReturn(create().setAuthorId(idAuthor))
                .compose(dao::findOneById)
                .compose(something -> dao.queryExecutor().executeMany(dslContext ->
                                                                              dslContext
                                                                                      .select(Tables.AUTHOR.convertFrom(Author::new),
                                                                                              DSL.multiset(  DSL.select(Tables.BOOK)
                                                                                                         .from(Tables.BOOK)
                                                                                                         .where(Tables.AUTHOR.ID.eq(Tables.BOOK.AUTHOR_ID))
                                                                                                         )
                                                                                                      .as("books")
                                                                                                      .convertFrom(r -> r.into(Book.class)))
                                                                                      .from(Tables.AUTHOR)
                                                                                      )
                                              .map(rows -> {
                                                System.out.println();
                                                Configuration configuration = PostgresConfigurationProvider.getInstance().createGeneratorConfig(
                                                        "ClassicReactiveVertxGenerator", "classic.reactive.regular", VertxGeneratorStrategy.class);

                                                // Connection is the only JDBC resource that we need
                                                // PreparedStatement and ResultSet are handled by jOOQ, internally
                                                try (Connection conn = DriverManager.getConnection(configuration.getJdbc().getUrl(), configuration.getJdbc().getUser(), configuration.getJdbc().getPassword())) {
                                                  // ...


                                                  Result<Record2<AuthorRecord, List<Book>>> toto = DSL.using(conn)
                                                                                                           .select(Tables.AUTHOR,
                                                                                                                   DSL.multiset(DSL.select(Tables.BOOK)
                                                                                                                                        .from(Tables.BOOK)
                                                                                                                                        .where(Tables.AUTHOR.ID.eq(Tables.BOOK.AUTHOR_ID))
                                                                                                                           )
                                                                                                                           .as("books")
                                                                                                                           .convertFrom(r -> r.into(Book.class)))
                                                                                                           .from(Tables.AUTHOR)
                                                                                                           .fetch();
                                                System.out.println();
                                                } catch (SQLException e) {
                                                  throw new RuntimeException(e);
                                                }
                                                return something;
                                              }))
                .compose(something -> dao.queryExecutor().executeMany(dslContext ->
                                                                              dslContext
                                                                                      .select(Tables.BOOK
                                                                                      ,  DSL.select(Tables.AUTHOR)
                                                                                                 .from(Tables.AUTHOR)
                                                                                        .where(Tables.AUTHOR.ID.eq(Tables.BOOK.AUTHOR_ID))
                                                                                              .asField("authors"))
                                                                                      .from(Tables.BOOK)
                                                                                      .where(Tables.BOOK.LABEL.containsIgnoreCase(something.getLabel())))
                        .compose(rows -> {
                         // BookRecord test = (BookRecord) rows.get(0).types().get(BookRecord.class, Tables.BOOK.getName());
                            Assert.assertEquals(1L, rows.size());
                            return dao
                                    .deleteById(getId(something))
                                    .map(deletedRows -> {
                                        Assert.assertEquals(1l, deletedRows.longValue());
                                        return null;
                                    });
                        }))
                .onComplete(countdownLatchHandler(latch)))
        ;
        await(latch);
    }


}
