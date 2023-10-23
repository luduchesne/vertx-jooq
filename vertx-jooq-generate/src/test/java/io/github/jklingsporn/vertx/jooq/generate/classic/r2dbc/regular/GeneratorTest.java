package io.github.jklingsporn.vertx.jooq.generate.classic.r2dbc.regular;

import io.github.jklingsporn.vertx.jooq.generate.AbstractVertxGeneratorTest;
import io.github.jklingsporn.vertx.jooq.generate.PostgresConfigurationProvider;
import io.github.jklingsporn.vertx.jooq.generate.VertxGeneratorStrategy;
import io.github.jklingsporn.vertx.jooq.generate.classic.ClassicR2dbcVertxGenerator;
import io.github.jklingsporn.vertx.jooq.generate.classic.ClassicReactiveVertxGenerator;

/**
 * Created by jklingsporn on 17.09.16.
 */
public class GeneratorTest extends AbstractVertxGeneratorTest {


    public GeneratorTest() {
        super(ClassicR2dbcVertxGenerator.class, VertxGeneratorStrategy.class,"classic.r2dbc.regular", PostgresConfigurationProvider.getInstance());
    }

}


