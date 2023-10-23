/*
 * This file is generated by jOOQ.
 */
package generated.rx3.reactive.guice.tables.records;


import generated.rx3.reactive.guice.tables.Book;
import generated.rx3.reactive.guice.tables.interfaces.IBook;

import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


import static io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo.*;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BookRecord extends UpdatableRecordImpl<BookRecord> implements VertxPojo, Record4<Integer, String, Long, Integer>, IBook {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>vertx.BOOK.id</code>.
     */
    @Override
    public BookRecord setId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>vertx.BOOK.id</code>.
     */
    @Override
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>vertx.BOOK.label</code>.
     */
    @Override
    public BookRecord setLabel(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>vertx.BOOK.label</code>.
     */
    @Override
    public String getLabel() {
        return (String) get(1);
    }

    /**
     * Setter for <code>vertx.BOOK.long_Field</code>.
     */
    @Override
    public BookRecord setLongField(Long value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>vertx.BOOK.long_Field</code>.
     */
    @Override
    public Long getLongField() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>vertx.BOOK.author_id</code>.
     */
    @Override
    public BookRecord setAuthorId(Integer value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>vertx.BOOK.author_id</code>.
     */
    @Override
    public Integer getAuthorId() {
        return (Integer) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, String, Long, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Integer, String, Long, Integer> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Book.BOOK.ID;
    }

    @Override
    public Field<String> field2() {
        return Book.BOOK.LABEL;
    }

    @Override
    public Field<Long> field3() {
        return Book.BOOK.LONG_FIELD;
    }

    @Override
    public Field<Integer> field4() {
        return Book.BOOK.AUTHOR_ID;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getLabel();
    }

    @Override
    public Long component3() {
        return getLongField();
    }

    @Override
    public Integer component4() {
        return getAuthorId();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getLabel();
    }

    @Override
    public Long value3() {
        return getLongField();
    }

    @Override
    public Integer value4() {
        return getAuthorId();
    }

    @Override
    public BookRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public BookRecord value2(String value) {
        setLabel(value);
        return this;
    }

    @Override
    public BookRecord value3(Long value) {
        setLongField(value);
        return this;
    }

    @Override
    public BookRecord value4(Integer value) {
        setAuthorId(value);
        return this;
    }

    @Override
    public BookRecord values(Integer value1, String value2, Long value3, Integer value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IBook from) {
        setId(from.getId());
        setLabel(from.getLabel());
        setLongField(from.getLongField());
        setAuthorId(from.getAuthorId());
        resetChangedOnNotNull();
    }

    @Override
    public <E extends IBook> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached BookRecord
     */
    public BookRecord() {
        super(Book.BOOK);
    }

    /**
     * Create a detached, initialised BookRecord
     */
    public BookRecord(Integer id, String label, Long longField, Integer authorId) {
        super(Book.BOOK);

        setId(id);
        setLabel(label);
        setLongField(longField);
        setAuthorId(authorId);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised BookRecord
     */
    public BookRecord(generated.rx3.reactive.guice.tables.pojos.Book value) {
        super(Book.BOOK);

        if (value != null) {
            setId(value.getId());
            setLabel(value.getLabel());
            setLongField(value.getLongField());
            setAuthorId(value.getAuthorId());
            resetChangedOnNotNull();
        }
    }

        public BookRecord(io.vertx.core.json.JsonObject json) {
                this();
                fromJson(json);
        }
}
