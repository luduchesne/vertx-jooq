# maven
```
<dependency>
  <groupId>io.github.jklingsporn</groupId>
  <artifactId>vertx-jooq-rx-reactive</artifactId>
  <version>6.5.6-RC3</version>
</dependency>
```

# maven code generator configuration example for postgres
The following code-snippet can be copy-pasted into your pom.xml to generate code from your Postgres database schema.

**Watch out for placeholders beginning with 'YOUR_xyz' though! E.g. you have to define credentials for DB access and specify the target directory where jOOQ
should put the generated code into, otherwise it won't run!**

After you replaced all placeholders with valid values, you should be able to run `mvn generate-sources` which creates all POJOs and DAOs into the target directory you specified.

If you are new to jOOQ, I recommend to read the awesome [jOOQ documentation](http://www.jooq.org/doc/latest/manual/), especially the chapter about
[code generation](http://www.jooq.org/doc/latest/manual/code-generation/).

```
<project>
...your project configuration here...

  <dependencies>
    ...your other dependencies...
    <dependency>
      <groupId>org.jooq</groupId>
      <artifactId>jooq</artifactId>
      <version>3.16.4</version>
    </dependency>
    <dependency>
      <groupId>io.github.jklingsporn</groupId>
      <artifactId>vertx-jooq-rx-reactive</artifactId>
      <version>6.5.6-RC3</version>
    </dependency>
  </dependencies>
  <build>
    <plugins>
      <plugin>
          <!-- Specify the maven code generator plugin -->
          <groupId>org.jooq</groupId>
          <artifactId>jooq-codegen-maven</artifactId>
          <version>3.16.4</version>

          <!-- The plugin should hook into the generate goal -->
          <executions>
              <execution>
                  <goals>
                      <goal>generate</goal>
                  </goals>
              </execution>
          </executions>

          <dependencies>
              <dependency>
									<groupId>org.postgresql</groupId>
									<artifactId>postgresql</artifactId>
									<version>42.2.2</version>
							</dependency>
              <dependency>
                  <groupId>io.github.jklingsporn</groupId>
                  <artifactId>vertx-jooq-generate</artifactId>
                  <version>6.5.6-RC3</version>
              </dependency>
          </dependencies>

          <!-- Specify the plugin configuration.
               The configuration format is the same as for the standalone code generator -->
          <configuration>
              <!-- JDBC connection parameters -->
              <jdbc>
                  <driver>org.postgresql.Driver</driver>
                  <url>YOUR_JDBC_URL_HERE</url>
                  <user>YOUR_DB_USER_HERE</user>
                  <password>YOUR_DB_PASSWORD_HERE</password>
              </jdbc>

              <!-- Generator parameters -->
              <generator>
                  <name>io.github.jklingsporn.vertx.jooq.generate.rx.RXReactiveVertxGenerator</name>
                  <!-- use 'io.github.jklingsporn.vertx.jooq.generate.rx.RXReactiveGuiceVertxGenerator' to enable Guice DI -->
                  <database>
                      <name>org.jooq.meta.postgres.PostgresDatabase</name>
                      <includes>.*</includes>
                      <inputSchema>YOUR_INPUT_SCHEMA</inputSchema>
                      <outputSchema>YOUR_OUTPUT_SCHEMA</outputSchema>
                      <unsignedTypes>false</unsignedTypes>
                      <forcedTypes>
                          <!-- Convert tinyint to boolean -->
                          <forcedType>
                              <name>BOOLEAN</name>
                              <types>(?i:TINYINT)</types>
                          </forcedType>
                      </forcedTypes>
                  </database>
                  <target>
                      <!-- This is where jOOQ will put your files -->
                      <packageName>YOUR_TARGET_PACKAGE_HERE</packageName>
                      <directory>YOUR_TARGET_DIRECTORY_HERE</directory>
                  </target>
                  <generate>
                      <interfaces>true</interfaces>
                      <daos>true</daos>
                      <fluentSetters>true</fluentSetters>
                  </generate>


                  <strategy>
                      <name>io.github.jklingsporn.vertx.jooq.generate.VertxGeneratorStrategy</name>
                  </strategy>
              </generator>

          </configuration>
      </plugin>
    </plugins>
  </build>
</project>
```
# gradle

The following code-snippet can be copy-pasted into your `build.gradle` to generate code from your postgresql database schema.

```gradle
buildscript {
    ext {
        vertx_jooq_version = '6.5.0'
        postgresql_version = '42.2.2'
    }
    repositories {
        mavenLocal()
        mavenCentral()
    }
    dependencies {
        classpath "io.github.jklingsporn:vertx-jooq-generate:$vertx_jooq_version"
        classpath "org.postgresql:postgresql:$postgresql_version"
    }
}

import groovy.xml.MarkupBuilder
import org.jooq.util.GenerationTool

import javax.xml.bind.JAXB

group 'your group id'
version 'your project version'

apply plugin: 'java'

dependencies {
    compile "io.github.jklingsporn:vertx-jooq-rx-reactive:$vertx_jooq_version"
    testCompile group: 'junit', name: 'junit', version: '4.12'
}

task jooqGenerate {
    doLast() {
        def writer = new StringWriter()
        new MarkupBuilder(writer)
                .configuration('xmlns': 'http://www.jooq.org/xsd/jooq-codegen-3.15.5.xsd') {
            jdbc {
                driver('org.postgresql.Driver')
                url('jdbc:postgresql://IP:PORT/DATABASE')
                user('YOUR_USER')
                password('YOUR_PASSWORD')
            }
            generator {
                name('io.github.jklingsporn.vertx.jooq.generate.rx.RXReactiveVertxGenerator')
                database {
                    name('org.jooq.meta.postgres.PostgresDatabase')
                    include('.*')
                    excludes('schema_version')
                    inputSchema('public')
                    includeTables(true)
                    includeRoutines(true)
                    includePackages(false)
                    includeUDTs(true)
                    includeSequences(true)
                }
                generate([:]) {
                    deprecated(false)
                    records(false)
                    interfaces(true)
                    fluentSetters(true)
                    pojos(true)
                    daos(true)
                }
                target() {
                    packageName('this.is.an.example')
                    directory("$projectDir/src/main/java")
                }
                strategy {
                    name('io.github.jklingsporn.vertx.jooq.generate.VertxGeneratorStrategy')
                }
            }
        }
        GenerationTool.generate(
                JAXB.unmarshal(new StringReader(writer.toString()), org.jooq.meta.jaxb.Configuration.class)
        )
    }
}
```

# programmatic configuration of the code generator
See the [AbstractDatabaseConfigurationProvider](../vertx-jooq-generate/src/test/java/io/github/jklingsporn/vertx/jooq/generate/AbstractDatabaseConfigurationProvider.java)
of how to setup the generator programmatically.

## usage
```
//Setup your jOOQ configuration
Configuration configuration = new DefaultConfiguration();
configuration.set(SQLDialect.POSTGRES);
//no other DB-Configuration necessary because jOOQ is only used to render our statements - not for execution

//setup Vertx
Vertx vertx = Vertx.vertx();
//setup the client
PgPoolOptions config = new PgPoolOptions().setHost("127.0.0.1").setPort(5432).setUsername("vertx").setDatabase("postgres").setPassword("password");
PgClient client = PgClient.pool(vertx, config);

//instantiate a DAO (which is generated for you)
SomethingDao dao = new SomethingDao(configuration, client);

//fetch something with ID 123...
dao.findOneById(123)
    .doOnEvent((something,x)->{
        		if(x==null){
            		opt.ifPresent(something -> vertx.eventBus().send("sendSomething",something.toJson()));
        		}else{
        				System.err.println("Something failed badly: "+x.getMessage());
        		}
        });

//maybe consume it in another verticle
vertx.eventBus().<JsonObject>consumer("sendSomething", jsonEvent->{
    JsonObject message = jsonEvent.body();
    //Convert it back into a POJO...
    Something something = new Something(message);
    //... change some values
    something.setSomeregularnumber(456);
    //... and update it into the DB
    Single<Integer> updatedFuture = dao.update(something);

});

//or do you prefer writing your own type-safe SQL?
ReactiveRXGenericQueryExecutor queryExecutor = new ReactiveRXGenericQueryExecutor(client);
Single<Integer> updatedCustomFuture = queryExecutor.execute(dslContext -> dslContext
			.update(Tables.SOMETHING)
			.set(Tables.SOMETHING.SOMEREGULARNUMBER,456)
			.where(Tables.SOMETHING.SOMEID.eq(something.getSomeid())));

//check for completion
updatedCustomFuture.doOnEvent((updated,x)->{
			if(x==null){
					System.out.println("Rows updated: "+updated);
			}else{
					System.err.println("Something failed badly: "+x.getMessage());
			}
	 });
```
More advanced examples can be found in [the tests](https://github.com/jklingsporn/vertx-jooq/blob/master/vertx-jooq-generate/src/test/java/io/github/jklingsporn/vertx/jooq/generate/rx/RXTestBase.java).

# known issues
- Although postgres and the reactive driver permit `false` or `true` as valid JSON, this is not supported. JSON- and JSONB-fields are automatically mapped to a
`io.vertx.core.json.JsonObject` (or array) which cannot handle those types.
