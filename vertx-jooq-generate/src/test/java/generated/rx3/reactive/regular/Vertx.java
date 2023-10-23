/*
 * This file is generated by jOOQ.
 */
package generated.rx3.reactive.regular;


import generated.rx3.reactive.regular.tables.Author;
import generated.rx3.reactive.regular.tables.Book;
import generated.rx3.reactive.regular.tables.Something;
import generated.rx3.reactive.regular.tables.Somethingcomposite;
import generated.rx3.reactive.regular.tables.Somethingwithoutjson;

import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Sequence;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Vertx extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>vertx</code>
     */
    public static final Vertx VERTX = new Vertx();

    /**
     * The table <code>vertx.AUTHOR</code>.
     */
    public final Author AUTHOR = Author.AUTHOR;

    /**
     * The table <code>vertx.BOOK</code>.
     */
    public final Book BOOK = Book.BOOK;

    /**
     * The table <code>vertx.something</code>.
     */
    public final Something SOMETHING = Something.SOMETHING;

    /**
     * The table <code>vertx.somethingComposite</code>.
     */
    public final Somethingcomposite SOMETHINGCOMPOSITE = Somethingcomposite.SOMETHINGCOMPOSITE;

    /**
     * The table <code>vertx.somethingWithoutJson</code>.
     */
    public final Somethingwithoutjson SOMETHINGWITHOUTJSON = Somethingwithoutjson.SOMETHINGWITHOUTJSON;

    /**
     * No further instances allowed
     */
    private Vertx() {
        super("vertx", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Sequence<?>> getSequences() {
        return Arrays.asList(
            Sequences.SOMETHING_SOMEID_SEQ,
            Sequences.SOMETHINGWITHOUTJSON_SOMEID_SEQ
        );
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.asList(
            Author.AUTHOR,
            Book.BOOK,
            Something.SOMETHING,
            Somethingcomposite.SOMETHINGCOMPOSITE,
            Somethingwithoutjson.SOMETHINGWITHOUTJSON
        );
    }
}
