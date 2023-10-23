/*
 * This file is generated by jOOQ.
 */
package generated.rx3.reactive.regular.tables.pojos;


import generated.rx3.reactive.regular.tables.interfaces.IAuthor;

import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;


import static io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo.*;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Author implements VertxPojo, IAuthor {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;

    public Author() {}

    public Author(IAuthor value) {
        this.id = value.getId();
        this.name = value.getName();
    }

    public Author(
        Integer id,
        String name
    ) {
        this.id = id;
        this.name = name;
    }

        public Author(io.vertx.core.json.JsonObject json) {
                this();
                fromJson(json);
        }

    /**
     * Getter for <code>vertx.AUTHOR.id</code>.
     */
    @Override
    public Integer getId() {
        return this.id;
    }

    /**
     * Setter for <code>vertx.AUTHOR.id</code>.
     */
    @Override
    public Author setId(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Getter for <code>vertx.AUTHOR.name</code>.
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Setter for <code>vertx.AUTHOR.name</code>.
     */
    @Override
    public Author setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Author other = (Author) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        }
        else if (!this.id.equals(other.id))
            return false;
        if (this.name == null) {
            if (other.name != null)
                return false;
        }
        else if (!this.name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Author (");

        sb.append(id);
        sb.append(", ").append(name);

        sb.append(")");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(IAuthor from) {
        setId(from.getId());
        setName(from.getName());
    }

    @Override
    public <E extends IAuthor> E into(E into) {
        into.from(this);
        return into;
    }
}
