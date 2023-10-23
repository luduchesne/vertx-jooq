/*
 * This file is generated by jOOQ.
 */
package generated.classic.reactive.regular.tables;


import generated.classic.reactive.regular.Keys;
import generated.classic.reactive.regular.Vertx;
import generated.classic.reactive.regular.tables.records.BookRecord;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function4;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row4;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Book extends TableImpl<BookRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>vertx.BOOK</code>
     */
    public static final Book BOOK = new Book();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BookRecord> getRecordType() {
        return BookRecord.class;
    }

    /**
     * The column <code>vertx.BOOK.id</code>.
     */
    public final TableField<BookRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>vertx.BOOK.label</code>.
     */
    public final TableField<BookRecord, String> LABEL = createField(DSL.name("label"), SQLDataType.VARCHAR(512), this, "");

    /**
     * The column <code>vertx.BOOK.long_Field</code>.
     */
    public final TableField<BookRecord, Long> LONG_FIELD = createField(DSL.name("long_Field"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>vertx.BOOK.author_id</code>.
     */
    public final TableField<BookRecord, Integer> AUTHOR_ID = createField(DSL.name("author_id"), SQLDataType.INTEGER.nullable(false), this, "");

    private Book(Name alias, Table<BookRecord> aliased) {
        this(alias, aliased, null);
    }

    private Book(Name alias, Table<BookRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>vertx.BOOK</code> table reference
     */
    public Book(String alias) {
        this(DSL.name(alias), BOOK);
    }

    /**
     * Create an aliased <code>vertx.BOOK</code> table reference
     */
    public Book(Name alias) {
        this(alias, BOOK);
    }

    /**
     * Create a <code>vertx.BOOK</code> table reference
     */
    public Book() {
        this(DSL.name("BOOK"), null);
    }

    public <O extends Record> Book(Table<O> child, ForeignKey<O, BookRecord> key) {
        super(child, key, BOOK);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Vertx.VERTX;
    }

    @Override
    public UniqueKey<BookRecord> getPrimaryKey() {
        return Keys.BOOK_PKEY;
    }

    @Override
    public List<ForeignKey<BookRecord, ?>> getReferences() {
        return Arrays.asList(Keys.BOOK__AUTHOR_BOOK);
    }

    private transient Author _author;

    /**
     * Get the implicit join path to the <code>vertx.AUTHOR</code> table.
     */
    public Author author() {
        if (_author == null)
            _author = new Author(this, Keys.BOOK__AUTHOR_BOOK);

        return _author;
    }

    @Override
    public Book as(String alias) {
        return new Book(DSL.name(alias), this);
    }

    @Override
    public Book as(Name alias) {
        return new Book(alias, this);
    }

    @Override
    public Book as(Table<?> alias) {
        return new Book(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Book rename(String name) {
        return new Book(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Book rename(Name name) {
        return new Book(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Book rename(Table<?> name) {
        return new Book(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, String, Long, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function4<? super Integer, ? super String, ? super Long, ? super Integer, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function4<? super Integer, ? super String, ? super Long, ? super Integer, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
