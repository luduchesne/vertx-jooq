/*
 * This file is generated by jOOQ.
 */
package generated.classic.reactive.guice.tables.interfaces;


import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;

import java.io.Serializable;


import static io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo.*;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public interface IBook extends VertxPojo, Serializable {

    /**
     * Setter for <code>vertx.BOOK.id</code>.
     */
    public IBook setId(Integer value);

    /**
     * Getter for <code>vertx.BOOK.id</code>.
     */
    public Integer getId();

    /**
     * Setter for <code>vertx.BOOK.label</code>.
     */
    public IBook setLabel(String value);

    /**
     * Getter for <code>vertx.BOOK.label</code>.
     */
    public String getLabel();

    /**
     * Setter for <code>vertx.BOOK.long_Field</code>.
     */
    public IBook setLongField(Long value);

    /**
     * Getter for <code>vertx.BOOK.long_Field</code>.
     */
    public Long getLongField();

    /**
     * Setter for <code>vertx.BOOK.author_id</code>.
     */
    public IBook setAuthorId(Integer value);

    /**
     * Getter for <code>vertx.BOOK.author_id</code>.
     */
    public Integer getAuthorId();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common
     * interface IBook
     */
    public void from(IBook from);

    /**
     * Copy data into another generated Record/POJO implementing the common
     * interface IBook
     */
    public <E extends IBook> E into(E into);

        @Override
        public default IBook fromJson(io.vertx.core.json.JsonObject json) {
                setOrThrow(this::setId,json::getInteger,"id","java.lang.Integer");
                setOrThrow(this::setLabel,json::getString,"label","java.lang.String");
                setOrThrow(this::setLongField,json::getLong,"long_Field","java.lang.Long");
                setOrThrow(this::setAuthorId,json::getInteger,"author_id","java.lang.Integer");
                return this;
        }


        @Override
        public default io.vertx.core.json.JsonObject toJson() {
                io.vertx.core.json.JsonObject json = new io.vertx.core.json.JsonObject();
                json.put("id",getId());
                json.put("label",getLabel());
                json.put("long_Field",getLongField());
                json.put("author_id",getAuthorId());
                return json;
        }

}
