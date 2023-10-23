/*
 * This file is generated by jOOQ.
 */
package generated.rx3.reactive.regular.tables.records;


import generated.rx3.reactive.regular.tables.Somethingwithoutjson;
import generated.rx3.reactive.regular.tables.interfaces.ISomethingwithoutjson;

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
public class SomethingwithoutjsonRecord extends UpdatableRecordImpl<SomethingwithoutjsonRecord> implements VertxPojo, Record2<Integer, String>, ISomethingwithoutjson {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>vertx.somethingWithoutJson.someId</code>.
     */
    @Override
    public SomethingwithoutjsonRecord setSomeid(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>vertx.somethingWithoutJson.someId</code>.
     */
    @Override
    public Integer getSomeid() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>vertx.somethingWithoutJson.someString</code>.
     */
    @Override
    public SomethingwithoutjsonRecord setSomestring(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>vertx.somethingWithoutJson.someString</code>.
     */
    @Override
    public String getSomestring() {
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
        return Somethingwithoutjson.SOMETHINGWITHOUTJSON.SOMEID;
    }

    @Override
    public Field<String> field2() {
        return Somethingwithoutjson.SOMETHINGWITHOUTJSON.SOMESTRING;
    }

    @Override
    public Integer component1() {
        return getSomeid();
    }

    @Override
    public String component2() {
        return getSomestring();
    }

    @Override
    public Integer value1() {
        return getSomeid();
    }

    @Override
    public String value2() {
        return getSomestring();
    }

    @Override
    public SomethingwithoutjsonRecord value1(Integer value) {
        setSomeid(value);
        return this;
    }

    @Override
    public SomethingwithoutjsonRecord value2(String value) {
        setSomestring(value);
        return this;
    }

    @Override
    public SomethingwithoutjsonRecord values(Integer value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(ISomethingwithoutjson from) {
        setSomeid(from.getSomeid());
        setSomestring(from.getSomestring());
        resetChangedOnNotNull();
    }

    @Override
    public <E extends ISomethingwithoutjson> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SomethingwithoutjsonRecord
     */
    public SomethingwithoutjsonRecord() {
        super(Somethingwithoutjson.SOMETHINGWITHOUTJSON);
    }

    /**
     * Create a detached, initialised SomethingwithoutjsonRecord
     */
    public SomethingwithoutjsonRecord(Integer someid, String somestring) {
        super(Somethingwithoutjson.SOMETHINGWITHOUTJSON);

        setSomeid(someid);
        setSomestring(somestring);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised SomethingwithoutjsonRecord
     */
    public SomethingwithoutjsonRecord(generated.rx3.reactive.regular.tables.pojos.Somethingwithoutjson value) {
        super(Somethingwithoutjson.SOMETHINGWITHOUTJSON);

        if (value != null) {
            setSomeid(value.getSomeid());
            setSomestring(value.getSomestring());
            resetChangedOnNotNull();
        }
    }

        public SomethingwithoutjsonRecord(io.vertx.core.json.JsonObject json) {
                this();
                fromJson(json);
        }
}
