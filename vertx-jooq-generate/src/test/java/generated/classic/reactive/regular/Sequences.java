/*
 * This file is generated by jOOQ.
 */
package generated.classic.reactive.regular;


import org.jooq.Sequence;
import org.jooq.impl.Internal;


/**
 * Convenience access to all sequences in vertx
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

    /**
     * The sequence <code>vertx.something_someId_seq</code>
     */
    public static final Sequence<Integer> SOMETHING_SOMEID_SEQ = Internal.createSequence("something_someId_seq", Vertx.VERTX, org.jooq.impl.SQLDataType.INTEGER.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>vertx.somethingWithoutJson_someId_seq</code>
     */
    public static final Sequence<Integer> SOMETHINGWITHOUTJSON_SOMEID_SEQ = Internal.createSequence("somethingWithoutJson_someId_seq", Vertx.VERTX, org.jooq.impl.SQLDataType.INTEGER.nullable(false), null, null, null, null, false, null);
}
