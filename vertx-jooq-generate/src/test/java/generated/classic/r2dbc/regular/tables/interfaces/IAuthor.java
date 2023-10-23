/*
 * This file is generated by jOOQ.
 */
package generated.classic.r2dbc.regular.tables.interfaces;


import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;

import java.io.Serializable;


import static io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo.*;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public interface IAuthor extends VertxPojo, Serializable {

    /**
     * Setter for <code>vertx.AUTHOR.id</code>.
     */
    public IAuthor setId(Integer value);

    /**
     * Getter for <code>vertx.AUTHOR.id</code>.
     */
    public Integer getId();

    /**
     * Setter for <code>vertx.AUTHOR.name</code>.
     */
    public IAuthor setName(String value);

    /**
     * Getter for <code>vertx.AUTHOR.name</code>.
     */
    public String getName();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common
     * interface IAuthor
     */
    public void from(IAuthor from);

    /**
     * Copy data into another generated Record/POJO implementing the common
     * interface IAuthor
     */
    public <E extends IAuthor> E into(E into);

        @Override
        public default IAuthor fromJson(io.vertx.core.json.JsonObject json) {
                setOrThrow(this::setId,json::getInteger,"id","java.lang.Integer");
                setOrThrow(this::setName,json::getString,"name","java.lang.String");
                return this;
        }


        @Override
        public default io.vertx.core.json.JsonObject toJson() {
                io.vertx.core.json.JsonObject json = new io.vertx.core.json.JsonObject();
                json.put("id",getId());
                json.put("name",getName());
                return json;
        }

}
