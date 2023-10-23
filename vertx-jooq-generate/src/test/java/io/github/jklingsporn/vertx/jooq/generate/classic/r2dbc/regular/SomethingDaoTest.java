package io.github.jklingsporn.vertx.jooq.generate.classic.r2dbc.regular;

import org.jooq.Condition;
import org.jooq.exception.IntegrityConstraintViolationException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

import generated.classic.r2dbc.regular.Tables;
import generated.classic.r2dbc.regular.enums.Someenum;
import generated.classic.r2dbc.regular.tables.daos.SomethingDao;
import generated.classic.r2dbc.regular.tables.pojos.Something;
import io.github.jklingsporn.vertx.jooq.classic.r2dbc.R2dbcClassicGenericQueryExecutor;
import io.github.jklingsporn.vertx.jooq.classic.reactivepg.ReactiveClassicQueryExecutor;
import io.github.jklingsporn.vertx.jooq.generate.PostgresConfigurationProvider;
import io.github.jklingsporn.vertx.jooq.generate.ReactiveDatabaseClientProvider;
import io.github.jklingsporn.vertx.jooq.generate.classic.ClassicTestBase;
import io.github.jklingsporn.vertx.jooq.generate.converter.SomeJsonPojo;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.pgclient.PgException;
import io.vertx.sqlclient.Cursor;

/**
 * Created by jensklingsporn on 02.11.16.
 */
public class SomethingDaoTest extends ClassicTestBase<Something, Integer, Long, SomethingDao> {

    public SomethingDaoTest() {
        super(Tables.SOMETHING.SOMEHUGENUMBER, new SomethingDao(PostgresConfigurationProvider.getInstance().createDAOR2dbcConfiguration()));
    }

    @BeforeClass
    public static void beforeClass() throws Exception {
        PostgresConfigurationProvider.getInstance().setupDatabase();
    }

    @Override
    protected Something create() {
        return createWithId().setSomeid(null);
    }

    @Override
    protected Something createWithId() {
        Random random = new Random();
        Something something = new Something();
        something.setSomeid(random.nextInt());
        something.setSomedouble(random.nextDouble());
        something.setSomeregularnumber(random.nextInt());
        something.setSomehugenumber(random.nextLong());
        something.setSomejsonarray(new JsonArray().add(1).add(2).add(3));
        something.setSomejsonobject(new JsonObject().put("key", "value"));
        something.setSomecustomjsonobject(new SomeJsonPojo().setFoo("foo").setBar(4));
        something.setSomesmallnumber((short) random.nextInt(Short.MAX_VALUE));
        something.setSomeenum(Someenum.values()[random.nextInt(Someenum.values().length)]);
        something.setSomestring("my_string");
        something.setSometimestamp(LocalDateTime.now());
        something.setSomevertxjsonobject(new JsonObject().put("foo",true));
        something.setSometime(LocalTime.now());
        something.setSomedate(LocalDate.now());
        something.setSometimestampwithtz(OffsetDateTime.now());
        something.setSomebytea("foo".getBytes());
        something.setSomedecimal(new BigDecimal("1.23E3"));
        return something;
    }

    @Override
    protected Something setId(Something pojo, Integer id) {
        return pojo.setSomeid(id);
    }

    @Override
    protected Something setSomeO(Something pojo, Long someO) {
        return pojo.setSomehugenumber(someO);
    }

    @Override
    protected Integer getId(Something pojo) {
        return pojo.getSomeid();
    }

    @Override
    protected Long createSomeO() {
        return new Random().nextLong();
    }

    @Override
    protected Condition eqPrimaryKey(Integer id) {
        return Tables.SOMETHING.SOMEID.eq(id);
    }

    @Override
    protected void assertDuplicateKeyException(Throwable x) {
        Assert.assertEquals(IntegrityConstraintViolationException.class, x.getClass());
        IntegrityConstraintViolationException exception = (IntegrityConstraintViolationException) x;
        Assert.assertTrue(exception.getMessage().contains("duplicate key value violates unique constraint \"something_pkey\""));
    }

    @Test
    public void containsShouldSucceed() throws InterruptedException {
        //https://github.com/jklingsporn/vertx-jooq/issues/93
        CountDownLatch latch = new CountDownLatch(1);
        insertAndReturn(create())
                .compose(dao::findOneById)
                .compose(something -> dao.queryExecutor().findMany(dslContext -> dslContext.selectFrom(Tables.SOMETHING).where(Tables.SOMETHING.SOMESTRING.containsIgnoreCase(something.getSomestring())))
                        .compose(rows -> {
                            Assert.assertEquals(1L, rows.size());
                            return dao
                                    .deleteById(getId(something))
                                    .map(deletedRows -> {
                                        Assert.assertEquals(1l, deletedRows.longValue());
                                        return null;
                                    });
                        }))
                .onComplete(countdownLatchHandler(latch))
        ;
        await(latch);
    }


    @Test
    public void manualTransactionProcessingShouldSucceed() throws InterruptedException {
        Something pojo = createWithId();
        CountDownLatch completionLatch = new CountDownLatch(1);
        dao.queryExecutor().beginTransaction()
                .compose(
                        transactionQE -> transactionQE.execute(
                                        dslContext -> dslContext.insertInto(dao.getTable()).set(dslContext.newRecord(dao.getTable(), pojo))
                                ).map(toVoid(
                                        inserted -> Assert.assertEquals(1, inserted.intValue()))
                                ).compose(
                                        v -> transactionQE.executeAny(
                                                dslContext -> dslContext.selectFrom(dao.getTable()).where(eqPrimaryKey(pojo.getSomeid()))
                                        )
                                ).map(toVoid(Assert::assertNotNull))
                                                 .compose(v -> dao.findOneById(pojo.getSomeid()))
                                                 .map(toVoid(Assert::assertNull)) //not known outside of transaction
                                                 .compose(v -> transactionQE.commit())
                                                 .compose(v -> dao.findOneById(pojo.getSomeid())) //now known because we committed the transaction
                                                 .map(toVoid(Assert::assertNotNull))
                                                 .compose(v -> dao.deleteById(pojo.getSomeid()))
                                                 .map(toVoid(deleted -> Assert.assertEquals(1, deleted.intValue()))))
                .onComplete(countdownLatchHandler(completionLatch));
        await(completionLatch);
    }
    @Test
    public void beginTransactionCanNotBeCalledInTransaction(){
        CountDownLatch latch = new CountDownLatch(1);
        dao.queryExecutor()
                .beginTransaction()
                .compose(R2dbcClassicGenericQueryExecutor::beginTransaction)
                .otherwise(x -> {
                    Assert.assertNotNull(x);
                    Assert.assertEquals(IllegalStateException.class,x.getClass());
                    return null;
                }).onComplete(countdownLatchHandler(latch));
        await(latch);
    }

    @Test
    public void commitTransactionCanNotBeCalledOutsideTransaction(){
        CountDownLatch latch = new CountDownLatch(1);
        dao.queryExecutor().commit().onFailure(t->latch.countDown());
        await(latch);
    }

    @Test
    public void rollbackTransactionCanNotBeCalledOutsideTransaction(){
        CountDownLatch latch = new CountDownLatch(1);
        dao.queryExecutor().rollback().onFailure(t->latch.countDown());
        await(latch);
    }

    @Test
    public void illegalQueriesShouldRollbackTransaction() throws InterruptedException {
        Something pojo = createWithId();
        CountDownLatch completionLatch = new CountDownLatch(1);
        dao.queryExecutor().beginTransaction()
                .compose(
                        transactionQE -> transactionQE.execute(
                                        dslContext -> dslContext.insertInto(dao.getTable()).set(dslContext.newRecord(dao.getTable(), pojo))
                                ).map(toVoid(inserted -> Assert.assertEquals(1, inserted.intValue()))
                                ).compose(
                                        //insert again to trigger an exception
                                        v -> transactionQE.execute(
                                                dslContext -> dslContext.insertInto(dao.getTable()).set(dslContext.newRecord(dao.getTable(), pojo))
                                        ).otherwiseEmpty() //we know it failed, just recover from the exception
                                ).compose(v -> dao.findOneById(pojo.getSomeid()))
                                                 .map(toVoid(Assert::assertNull)) //not known because transaction was rolled back
                                                 .compose(v -> transactionQE.commit()) //should throw error because the transaction was already rolled back
                                                 .otherwise(x -> {
                                                     Assert.assertTrue("Wrong exception. Got: " + x.getMessage(), x.getMessage().contains("The database returned ROLLBACK"));
                                                     return null;
                                                 })
                ).onComplete(countdownLatchHandler(completionLatch));
        await(completionLatch);
    }

    @Test
    public void rollbackShouldNotExecuteTransactionalQueries() throws InterruptedException {
       Something pojo = createWithId();
        CountDownLatch completionLatch = new CountDownLatch(1);
        dao.queryExecutor().beginTransaction()
                .flatMap(transactionQE -> transactionQE.execute(dslContext -> dslContext.insertInto(dao.getTable()).set(dslContext.newRecord(dao.getTable(), pojo)))
                                                  .map(toVoid(inserted -> Assert.assertEquals(1, inserted.intValue())))
                                                  .flatMap(v -> transactionQE.rollback())
                                                  .flatMap(v -> dao.findOneById(pojo.getSomeid()))
                                                  .map(toVoid(Assert::assertNull))
                ).onComplete(countdownLatchHandler(completionLatch));
        await(completionLatch);
    }

    @Test
    public void convenientTransactionShouldSucceed() throws InterruptedException {
        Something pojo = createWithId();
        CountDownLatch completionLatch = new CountDownLatch(1);
        ( (R2dbcClassicGenericQueryExecutor)dao.queryExecutor()).transaction(
                        transactionQE -> transactionQE.execute(
                                        dslContext -> dslContext.insertInto(dao.getTable()).set(dslContext.newRecord(dao.getTable(), pojo))
                                ).map(toVoid(
                                        inserted -> Assert.assertEquals(1, inserted.intValue()))
                                ).compose(
                                        v -> transactionQE.findOneRow(
                                                dslContext -> dslContext.selectFrom(dao.getTable()).where(eqPrimaryKey(pojo.getSomeid()))
                                        )
                                ).map(toVoid(Assert::assertNotNull))
                                                 .compose(v -> dao.findOneById(pojo.getSomeid()))
                                                 .map(toVoid(Assert::assertNull)) //not known outside of transaction
                ) //implicitly commit the transaction
                .compose(v -> dao.findOneById(pojo.getSomeid())) //now known because we committed the transaction
                .map(toVoid(Assert::assertNotNull))
                .compose(v -> dao.deleteById(pojo.getSomeid()))
                .map(toVoid(deleted -> Assert.assertEquals(1, deleted.intValue())))
                .onComplete(countdownLatchHandler(completionLatch)
                );
        await(completionLatch);
    }

    @Test
    public void rollbackTransactionsShouldReturnConnectionToPool(){
        Something pojo = createWithId();
        CountDownLatch completionLatch = new CountDownLatch(2);
        dao.insert(pojo)
                .map(toVoid(inserted -> Assert.assertEquals(1, inserted.intValue())))
                .onSuccess(v->completionLatch.countDown())
                .compose(v->{
                    /*
                     * Try to insert the same object inside a transaction. Prior to the fix for
                     * https://github.com/jklingsporn/vertx-jooq/issues/197 this test should not succeed
                     * and the connection pool will exhaust
                     */
                    Future<Void> result = Future.succeededFuture();
                    int max = ReactiveDatabaseClientProvider.POOL_SIZE + 1;
                    for (int i = 0; i < max; i++) {
                        result = result.compose(v2-> dao.queryExecutor().transaction(
                                transactionQE -> transactionQE.execute(
                                        //this should fail
                                        dslContext -> dslContext.insertInto(dao.getTable()).set(dslContext.newRecord(dao.getTable(), pojo))
                                ))).otherwise(x -> {
                            Assert.assertTrue("Wrong exception. Got: " + x.getMessage(), x.getMessage().toLowerCase().contains("duplicate"));
                            return null;
                        }).mapEmpty();
                    }
                    return result;
                }).onComplete(countdownLatchHandler(completionLatch))
        ;
        await(completionLatch);
    }


}
