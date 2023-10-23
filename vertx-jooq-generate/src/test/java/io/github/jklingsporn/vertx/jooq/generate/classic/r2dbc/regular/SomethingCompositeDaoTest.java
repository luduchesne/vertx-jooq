package io.github.jklingsporn.vertx.jooq.generate.classic.r2dbc.regular;

import org.jooq.Condition;
import org.jooq.Record2;
import org.jooq.exception.IntegrityConstraintViolationException;
import org.junit.Assert;
import org.junit.BeforeClass;

import java.util.Random;

import generated.classic.r2dbc.regular.Tables;
import generated.classic.r2dbc.regular.tables.daos.SomethingcompositeDao;
import generated.classic.r2dbc.regular.tables.pojos.Somethingcomposite;
import generated.classic.r2dbc.regular.tables.records.SomethingcompositeRecord;
import io.github.jklingsporn.vertx.jooq.generate.PostgresConfigurationProvider;
import io.github.jklingsporn.vertx.jooq.generate.ReactiveDatabaseClientProvider;
import io.github.jklingsporn.vertx.jooq.generate.classic.ClassicTestBase;
import io.vertx.core.json.JsonObject;
import io.vertx.pgclient.PgException;

/**
 * Created by jensklingsporn on 02.11.16.
 */
public class SomethingCompositeDaoTest extends ClassicTestBase<Somethingcomposite, Record2<Integer,Integer>, JsonObject, SomethingcompositeDao> {


    public SomethingCompositeDaoTest() {
        super(Tables.SOMETHINGCOMPOSITE.SOMEJSONOBJECT, new SomethingcompositeDao(PostgresConfigurationProvider.getInstance().createDAOR2dbcConfiguration()));
    }

    @BeforeClass
    public static void beforeClass() throws Exception {
        PostgresConfigurationProvider.getInstance().setupDatabase();
    }

    @Override
    protected Somethingcomposite create() {
        return createWithId();
    }

    @Override
    protected Somethingcomposite createWithId() {
        Somethingcomposite something = new Somethingcomposite();
        something.setSomeid(new Random().nextInt());
        something.setSomesecondid(new Random().nextInt());
        something.setSomejsonobject(new JsonObject().put("key", "value"));
        return something;
    }

    @Override
    protected Somethingcomposite setId(Somethingcomposite pojo, Record2<Integer, Integer> id) {
        return pojo.setSomeid(id.component1()).setSomesecondid(id.component2());
    }

    @Override
    protected Somethingcomposite setSomeO(Somethingcomposite pojo, JsonObject someO) {
        return pojo.setSomejsonobject(someO);
    }


    @Override
    protected Record2<Integer, Integer> getId(Somethingcomposite pojo) {
        SomethingcompositeRecord rec = new SomethingcompositeRecord();
        rec.from(pojo);
        return rec.key();
    }

    @Override
    protected JsonObject createSomeO() {
        return new JsonObject().put("foo","bar");
    }

    @Override
    protected Condition eqPrimaryKey(Record2<Integer, Integer> id) {
        return Tables.SOMETHINGCOMPOSITE.SOMEID.eq(id.component1()).and(Tables.SOMETHINGCOMPOSITE.SOMESECONDID.eq(id.component2()));
    }

    @Override
    protected void assertDuplicateKeyException(Throwable x) {
        Assert.assertEquals(IntegrityConstraintViolationException.class, x.getClass());
        IntegrityConstraintViolationException exception = (IntegrityConstraintViolationException) x;
        Assert.assertTrue(exception.getMessage().contains("duplicate key value violates unique constraint \"somethingComposite_pkey\""));
    }

}
