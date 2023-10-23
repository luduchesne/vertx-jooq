package io.github.jklingsporn.vertx.jooq.generate.classic;

import io.github.jklingsporn.vertx.jooq.generate.builder.DelegatingVertxGenerator;
import io.github.jklingsporn.vertx.jooq.generate.builder.VertxGeneratorBuilder;

/**
 * Created by jensklingsporn on 06.02.18.
 */
public class ClassicR2dbcVertxGenerator extends DelegatingVertxGenerator {

    public ClassicR2dbcVertxGenerator() {
        super(VertxGeneratorBuilder.init().withClassicAPI().withR2dbcDriver().build());
    }
}
