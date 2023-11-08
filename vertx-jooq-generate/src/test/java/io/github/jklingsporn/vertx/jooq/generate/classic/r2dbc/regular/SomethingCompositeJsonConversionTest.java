package io.github.jklingsporn.vertx.jooq.generate.classic.r2dbc.regular;

import java.util.Random;

import generated.classic.reactive.regular.tables.pojos.Somethingcomposite;
import io.github.jklingsporn.vertx.jooq.generate.AbstractJsonConversionTest;
import io.vertx.core.json.JsonObject;

/**
 * Created by jensklingsporn on 22.08.17.
 */
public class SomethingCompositeJsonConversionTest extends AbstractJsonConversionTest<Somethingcomposite>{

    @Override
    protected Somethingcomposite newPojo() {
        return new Somethingcomposite();
    }

    @Override
    protected Somethingcomposite newPojoWithRandomValues() {
        Random random = new Random();
        Somethingcomposite somethingComposite = new Somethingcomposite();
        somethingComposite.setSomeid(random.nextInt());
        somethingComposite.setSomesecondid(random.nextInt());
        somethingComposite.setSomejsonobject(new JsonObject().put("key", "value"));
        return somethingComposite;
    }

    @Override
    protected Somethingcomposite newPojo(JsonObject json) {
        return new Somethingcomposite(json);
    }

}
