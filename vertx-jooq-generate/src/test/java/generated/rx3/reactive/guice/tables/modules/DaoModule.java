package generated.rx3.reactive.guice.tables.modules;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import io.github.jklingsporn.vertx.jooq.rx3.VertxDAO;

public class DaoModule extends AbstractModule {
        @Override
        protected void configure() {
                bind(new TypeLiteral<VertxDAO<generated.rx3.reactive.guice.tables.records.AuthorRecord, generated.rx3.reactive.guice.tables.pojos.Author, java.lang.Integer>>() {}).to(generated.rx3.reactive.guice.tables.daos.AuthorDao.class).asEagerSingleton();
                bind(new TypeLiteral<VertxDAO<generated.rx3.reactive.guice.tables.records.BookRecord, generated.rx3.reactive.guice.tables.pojos.Book, java.lang.Integer>>() {}).to(generated.rx3.reactive.guice.tables.daos.BookDao.class).asEagerSingleton();
                bind(new TypeLiteral<VertxDAO<generated.rx3.reactive.guice.tables.records.SomethingRecord, generated.rx3.reactive.guice.tables.pojos.Something, java.lang.Integer>>() {}).to(generated.rx3.reactive.guice.tables.daos.SomethingDao.class).asEagerSingleton();
                bind(new TypeLiteral<VertxDAO<generated.rx3.reactive.guice.tables.records.SomethingcompositeRecord, generated.rx3.reactive.guice.tables.pojos.Somethingcomposite, org.jooq.Record2<java.lang.Integer, java.lang.Integer>>>() {}).to(generated.rx3.reactive.guice.tables.daos.SomethingcompositeDao.class).asEagerSingleton();
                bind(new TypeLiteral<VertxDAO<generated.rx3.reactive.guice.tables.records.SomethingwithoutjsonRecord, generated.rx3.reactive.guice.tables.pojos.Somethingwithoutjson, java.lang.Integer>>() {}).to(generated.rx3.reactive.guice.tables.daos.SomethingwithoutjsonDao.class).asEagerSingleton();
        }
}
