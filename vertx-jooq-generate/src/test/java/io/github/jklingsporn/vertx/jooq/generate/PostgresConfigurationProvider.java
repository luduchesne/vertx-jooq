package io.github.jklingsporn.vertx.jooq.generate;

import io.github.jklingsporn.vertx.jooq.generate.converter.CommaSeparatedStringIntoListConverter;
import io.github.jklingsporn.vertx.jooq.generate.converter.SomeJsonPojo;
import io.github.jklingsporn.vertx.jooq.generate.converter.SomeJsonPojoConverter;
import io.github.jklingsporn.vertx.jooq.shared.postgres.JSONBToJsonObjectConverter;
import io.r2dbc.pool.ConnectionPool;
import io.r2dbc.pool.ConnectionPoolConfiguration;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import io.vertx.core.json.JsonObject;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.meta.jaxb.Configuration;
import org.jooq.meta.jaxb.ForcedType;
import org.jooq.meta.jaxb.Jdbc;
import org.jooq.meta.postgres.PostgresDatabase;
import org.junit.Assert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jensklingsporn on 02.11.16.
 */
public class PostgresConfigurationProvider extends AbstractDatabaseConfigurationProvider {

    private static PostgresConfigurationProvider INSTANCE;

    private ConnectionPool connectionPool;
    public static PostgresConfigurationProvider getInstance() {
        return INSTANCE == null ? INSTANCE = new PostgresConfigurationProvider() : INSTANCE;
    }

    public  PostgresConfigurationProvider(){
        super();
        ConnectionFactory connectionFactory = ConnectionFactories.get(
                ConnectionFactoryOptions.builder()
                        .option(ConnectionFactoryOptions.DRIVER,"pool")
                        .option(ConnectionFactoryOptions.PROTOCOL,"postgresql") // driver identifier, PROTOCOL is delegated as DRIVER by the pool.
                        .option(ConnectionFactoryOptions.HOST,"127.0.0.1")
                        .option(ConnectionFactoryOptions.PORT,5432)
                        .option(ConnectionFactoryOptions.USER, Credentials.POSTGRES.getUser())
                        .option(ConnectionFactoryOptions.PASSWORD, Credentials.POSTGRES.getPassword())
                        .option(ConnectionFactoryOptions.DATABASE,"postgres")
                        .build()
        );
        ConnectionPoolConfiguration connectionPoolConfiguration = ConnectionPoolConfiguration
                                                                          .builder(connectionFactory)
                                                                          .initialSize(1)
                                                                          .maxSize(10)
                                                                          .build();

       connectionPool =  new ConnectionPool(connectionPoolConfiguration);

    }

    @Override
    public void setupDatabase() throws Exception {
        try
            (Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", Credentials.POSTGRES.getUser(), Credentials.POSTGRES.getPassword())) {
            connection.prepareStatement("DROP SCHEMA IF EXISTS vertx CASCADE;").execute();
            connection.prepareStatement("CREATE SCHEMA vertx;").execute();
            connection.prepareStatement("SET SCHEMA 'vertx';").execute();
            connection.prepareStatement("CREATE TYPE \"someEnum\" AS ENUM('FOO', 'BAR', 'BAZ');").execute();
            connection.prepareStatement("CREATE TABLE something (\n" +
                    "  \"someId\" SERIAL,\n" +
                    "  \"someString\" VARCHAR(45) NULL,\n" +
                    "  \"someHugeNumber\" BIGINT NULL,\n" +
                    "  \"someSmallNumber\" SMALLINT NULL,\n" +
                    "  \"someRegularNumber\" INTEGER NULL,\n" +
                    "  \"someDecimal\" DECIMAL NULL,\n" +
                    "  \"someDouble\" DOUBLE PRECISION NULL,\n" +
                    "  \"someEnum\" \"someEnum\" DEFAULT 'FOO' ,\n" +
                    "  \"someJsonObject\" VARCHAR(512) NULL,\n" +
                    "  \"someCustomJsonObject\" JSONB NULL,\n" +
                    "  \"someJsonArray\" VARCHAR(512) NULL,\n" +
                    "  \"someVertxJsonObject\" JSONB NULL,\n" +
                    "  \"someTime\" TIME NULL,\n" +
                    "  \"someDate\" DATE NULL,\n" +
                    "  \"someTimestamp\" TIMESTAMP NULL,\n" +
                    "  \"someTimestampWithTZ\" TIMESTAMP WITH TIME ZONE NULL,\n" +
                    "  \"someByteA\" bytea NULL,\n" +
                    "  \"someStringAsList\" VARCHAR(512) NULL,\n" +
                    "  PRIMARY KEY (\"someId\"));").execute();
            connection.prepareStatement("CREATE TABLE \"somethingComposite\" (\n" +
                    "  \"someId\" INTEGER NOT NULL,\n" +
                    "  \"someSecondId\" INTEGER NOT NULL,\n" +
                    "  \"someJsonObject\" VARCHAR(512) NULL,\n" +
                    "  PRIMARY KEY (\"someId\", \"someSecondId\"));\n").execute();
            connection.prepareStatement("CREATE TABLE \"somethingWithoutJson\" (\n" +
                    "  \"someId\" SERIAL,\n" +
                    "  \"someString\" VARCHAR(45) DEFAULT NULL,\n" +
                    "  PRIMARY KEY (\"someId\"));\n").execute();
            connection.prepareStatement("CREATE TABLE \"AUTHOR\" (\n" +
                                                "  \"id\" INTEGER NOT NULL,\n" +
                                                "  \"name\" VARCHAR(512) NULL,\n" +
                                                "  PRIMARY KEY (\"id\"));\n").execute();
            connection.prepareStatement("CREATE TABLE \"BOOK\" (\n" +
                                                "  \"id\" INTEGER NOT NULL,\n" +
                                                "  \"label\" VARCHAR(512) NULL,\n" +
                                                "  \"long_Field\" bigint,\n" +
                                                "  \"author_id\" INTEGER NOT NULL,\n" +
                                                "  PRIMARY KEY (\"id\"),\n " +
                                                "CONSTRAINT author_book FOREIGN KEY (author_id)\n" +
                                               "REFERENCES \"AUTHOR\" (id) MATCH SIMPLE);").execute();


        }catch (Throwable e){
            Assert.fail(e.getMessage());
        }
    }

    @Override
    public Configuration createGeneratorConfig(String generatorName, String packageName, Class<? extends VertxGeneratorStrategy> generatorStrategy){
        Jdbc jdbcConfig = new Jdbc();
        jdbcConfig.setDriver("org.postgresql.Driver");
        jdbcConfig.setUrl("jdbc:postgresql://127.0.0.1:5432/postgres");
        jdbcConfig.setUser(Credentials.POSTGRES.getUser());
        jdbcConfig.setPassword(Credentials.POSTGRES.getPassword());
        Configuration generatorConfig = createGeneratorConfig(generatorName, packageName, generatorStrategy, jdbcConfig, PostgresDatabase.class.getName());
        ForcedType customJsonMapping = new ForcedType();
        customJsonMapping.setUserType(SomeJsonPojo.class.getName());
        customJsonMapping.setConverter(SomeJsonPojoConverter.class.getName());
        customJsonMapping.setIncludeExpression("someCustomJsonObject");
        customJsonMapping.setIncludeTypes(".*");

        ForcedType jsonbToJsonObjectMapping = new ForcedType();
        jsonbToJsonObjectMapping.setUserType(JsonObject.class.getName());
        jsonbToJsonObjectMapping.setConverter(JSONBToJsonObjectConverter.class.getName());
        jsonbToJsonObjectMapping.setIncludeExpression("someVertxJsonObject");
        jsonbToJsonObjectMapping.setIncludeTypes(".*");

        ForcedType stringToCSListMapping = new ForcedType();
        stringToCSListMapping.setUserType("java.util.List<String>");
        stringToCSListMapping.setConverter(CommaSeparatedStringIntoListConverter.class.getName());
        stringToCSListMapping.setIncludeExpression("someStringAsList");
        stringToCSListMapping.setIncludeTypes(".*");

        List<ForcedType> forcedTypes = new ArrayList<>(generatorConfig.getGenerator().getDatabase().getForcedTypes());
        forcedTypes.add(customJsonMapping);
        forcedTypes.add(jsonbToJsonObjectMapping);
        forcedTypes.add(stringToCSListMapping);
        generatorConfig.getGenerator().getDatabase().setForcedTypes(forcedTypes);
        return generatorConfig;
    }

    @Override
    public org.jooq.Configuration createDAOConfiguration(){
        return new DefaultConfiguration().set(SQLDialect.POSTGRES);
    }

    public org.jooq.Configuration createDAOR2dbcConfiguration(){
        return new DefaultConfiguration().set(SQLDialect.POSTGRES).set(connectionPool);
    }

}
