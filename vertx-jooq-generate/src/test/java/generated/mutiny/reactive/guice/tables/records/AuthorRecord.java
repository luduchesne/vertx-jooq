/*
 * This file is generated by jOOQ.
 */
package generated.mutiny.reactive.guice.tables.records;


import generated.mutiny.reactive.guice.tables.Author;
import generated.mutiny.reactive.guice.tables.interfaces.IAuthor;

import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


import static io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo.*;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AuthorRecord extends UpdatableRecordImpl<AuthorRecord> implements VertxPojo, Record2<Integer, String>, IAuthor {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>vertx.AUTHOR.id</code>.
     */
    @Override
    public AuthorRecord setId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>vertx.AUTHOR.id</code>.
     */
    @Override
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>vertx.AUTHOR.name</code>.
     */
    @Override
    public AuthorRecord setName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>vertx.AUTHOR.name</code>.
     */
    @Override
    public String getName() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<Integer, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Author.AUTHOR.ID;
    }

    @Override
    public Field<String> field2() {
        return Author.AUTHOR.NAME;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public AuthorRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public AuthorRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public AuthorRecord values(Integer value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IAuthor from) {
        setId(from.getId());
        setName(from.getName());
        resetChangedOnNotNull();
    }

    @Override
    public <E extends IAuthor> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached AuthorRecord
     */
    public AuthorRecord() {
        super(Author.AUTHOR);
    }

    /**
     * Create a detached, initialised AuthorRecord
     */
    public AuthorRecord(Integer id, String name) {
        super(Author.AUTHOR);

        setId(id);
        setName(name);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised AuthorRecord
     */
    public AuthorRecord(generated.mutiny.reactive.guice.tables.pojos.Author value) {
        super(Author.AUTHOR);

        if (value != null) {
            setId(value.getId());
            setName(value.getName());
            resetChangedOnNotNull();
        }
    }

        public AuthorRecord(io.vertx.core.json.JsonObject json) {
                this();
                fromJson(json);
        }
}
