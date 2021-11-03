/*
 * This file is generated by jOOQ.
 */
package generated.classic.reactive.guice.tables.records;


import generated.classic.reactive.guice.enums.Someenum;
import generated.classic.reactive.guice.tables.Something;
import generated.classic.reactive.guice.tables.interfaces.ISomething;

import io.github.jklingsporn.vertx.jooq.generate.converter.SomeJsonPojo;
import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.List;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record17;
import org.jooq.Row17;
import org.jooq.impl.UpdatableRecordImpl;


import static io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo.*;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SomethingRecord extends UpdatableRecordImpl<SomethingRecord> implements VertxPojo, Record17<Integer, String, Long, Short, Integer, Double, Someenum, JsonObject, SomeJsonPojo, JsonArray, JsonObject, LocalTime, LocalDate, LocalDateTime, OffsetDateTime, byte[], List<String>>, ISomething {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>vertx.something.someId</code>.
     */
    @Override
    public SomethingRecord setSomeid(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>vertx.something.someId</code>.
     */
    @Override
    public Integer getSomeid() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>vertx.something.someString</code>.
     */
    @Override
    public SomethingRecord setSomestring(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>vertx.something.someString</code>.
     */
    @Override
    public String getSomestring() {
        return (String) get(1);
    }

    /**
     * Setter for <code>vertx.something.someHugeNumber</code>.
     */
    @Override
    public SomethingRecord setSomehugenumber(Long value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>vertx.something.someHugeNumber</code>.
     */
    @Override
    public Long getSomehugenumber() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>vertx.something.someSmallNumber</code>.
     */
    @Override
    public SomethingRecord setSomesmallnumber(Short value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>vertx.something.someSmallNumber</code>.
     */
    @Override
    public Short getSomesmallnumber() {
        return (Short) get(3);
    }

    /**
     * Setter for <code>vertx.something.someRegularNumber</code>.
     */
    @Override
    public SomethingRecord setSomeregularnumber(Integer value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>vertx.something.someRegularNumber</code>.
     */
    @Override
    public Integer getSomeregularnumber() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>vertx.something.someDouble</code>.
     */
    @Override
    public SomethingRecord setSomedouble(Double value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>vertx.something.someDouble</code>.
     */
    @Override
    public Double getSomedouble() {
        return (Double) get(5);
    }

    /**
     * Setter for <code>vertx.something.someEnum</code>.
     */
    @Override
    public SomethingRecord setSomeenum(Someenum value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>vertx.something.someEnum</code>.
     */
    @Override
    public Someenum getSomeenum() {
        return (Someenum) get(6);
    }

    /**
     * Setter for <code>vertx.something.someJsonObject</code>.
     */
    @Override
    public SomethingRecord setSomejsonobject(JsonObject value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>vertx.something.someJsonObject</code>.
     */
    @Override
    public JsonObject getSomejsonobject() {
        return (JsonObject) get(7);
    }

    /**
     * Setter for <code>vertx.something.someCustomJsonObject</code>.
     */
    @Override
    public SomethingRecord setSomecustomjsonobject(SomeJsonPojo value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>vertx.something.someCustomJsonObject</code>.
     */
    @Override
    public SomeJsonPojo getSomecustomjsonobject() {
        return (SomeJsonPojo) get(8);
    }

    /**
     * Setter for <code>vertx.something.someJsonArray</code>.
     */
    @Override
    public SomethingRecord setSomejsonarray(JsonArray value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>vertx.something.someJsonArray</code>.
     */
    @Override
    public JsonArray getSomejsonarray() {
        return (JsonArray) get(9);
    }

    /**
     * Setter for <code>vertx.something.someVertxJsonObject</code>.
     */
    @Override
    public SomethingRecord setSomevertxjsonobject(JsonObject value) {
        set(10, value);
        return this;
    }

    /**
     * Getter for <code>vertx.something.someVertxJsonObject</code>.
     */
    @Override
    public JsonObject getSomevertxjsonobject() {
        return (JsonObject) get(10);
    }

    /**
     * Setter for <code>vertx.something.someTime</code>.
     */
    @Override
    public SomethingRecord setSometime(LocalTime value) {
        set(11, value);
        return this;
    }

    /**
     * Getter for <code>vertx.something.someTime</code>.
     */
    @Override
    public LocalTime getSometime() {
        return (LocalTime) get(11);
    }

    /**
     * Setter for <code>vertx.something.someDate</code>.
     */
    @Override
    public SomethingRecord setSomedate(LocalDate value) {
        set(12, value);
        return this;
    }

    /**
     * Getter for <code>vertx.something.someDate</code>.
     */
    @Override
    public LocalDate getSomedate() {
        return (LocalDate) get(12);
    }

    /**
     * Setter for <code>vertx.something.someTimestamp</code>.
     */
    @Override
    public SomethingRecord setSometimestamp(LocalDateTime value) {
        set(13, value);
        return this;
    }

    /**
     * Getter for <code>vertx.something.someTimestamp</code>.
     */
    @Override
    public LocalDateTime getSometimestamp() {
        return (LocalDateTime) get(13);
    }

    /**
     * Setter for <code>vertx.something.someTimestampWithTZ</code>.
     */
    @Override
    public SomethingRecord setSometimestampwithtz(OffsetDateTime value) {
        set(14, value);
        return this;
    }

    /**
     * Getter for <code>vertx.something.someTimestampWithTZ</code>.
     */
    @Override
    public OffsetDateTime getSometimestampwithtz() {
        return (OffsetDateTime) get(14);
    }

    /**
     * Setter for <code>vertx.something.someByteA</code>.
     */
    @Override
    public SomethingRecord setSomebytea(byte[] value) {
        set(15, value);
        return this;
    }

    /**
     * Getter for <code>vertx.something.someByteA</code>.
     */
    @Override
    public byte[] getSomebytea() {
        return (byte[]) get(15);
    }

    /**
     * Setter for <code>vertx.something.someStringAsList</code>.
     */
    @Override
    public SomethingRecord setSomestringaslist(List<String> value) {
        set(16, value);
        return this;
    }

    /**
     * Getter for <code>vertx.something.someStringAsList</code>.
     */
    @Override
    public List<String> getSomestringaslist() {
        return (List<String>) get(16);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record17 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row17<Integer, String, Long, Short, Integer, Double, Someenum, JsonObject, SomeJsonPojo, JsonArray, JsonObject, LocalTime, LocalDate, LocalDateTime, OffsetDateTime, byte[], List<String>> fieldsRow() {
        return (Row17) super.fieldsRow();
    }

    @Override
    public Row17<Integer, String, Long, Short, Integer, Double, Someenum, JsonObject, SomeJsonPojo, JsonArray, JsonObject, LocalTime, LocalDate, LocalDateTime, OffsetDateTime, byte[], List<String>> valuesRow() {
        return (Row17) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Something.SOMETHING.SOMEID;
    }

    @Override
    public Field<String> field2() {
        return Something.SOMETHING.SOMESTRING;
    }

    @Override
    public Field<Long> field3() {
        return Something.SOMETHING.SOMEHUGENUMBER;
    }

    @Override
    public Field<Short> field4() {
        return Something.SOMETHING.SOMESMALLNUMBER;
    }

    @Override
    public Field<Integer> field5() {
        return Something.SOMETHING.SOMEREGULARNUMBER;
    }

    @Override
    public Field<Double> field6() {
        return Something.SOMETHING.SOMEDOUBLE;
    }

    @Override
    public Field<Someenum> field7() {
        return Something.SOMETHING.SOMEENUM;
    }

    @Override
    public Field<JsonObject> field8() {
        return Something.SOMETHING.SOMEJSONOBJECT;
    }

    @Override
    public Field<SomeJsonPojo> field9() {
        return Something.SOMETHING.SOMECUSTOMJSONOBJECT;
    }

    @Override
    public Field<JsonArray> field10() {
        return Something.SOMETHING.SOMEJSONARRAY;
    }

    @Override
    public Field<JsonObject> field11() {
        return Something.SOMETHING.SOMEVERTXJSONOBJECT;
    }

    @Override
    public Field<LocalTime> field12() {
        return Something.SOMETHING.SOMETIME;
    }

    @Override
    public Field<LocalDate> field13() {
        return Something.SOMETHING.SOMEDATE;
    }

    @Override
    public Field<LocalDateTime> field14() {
        return Something.SOMETHING.SOMETIMESTAMP;
    }

    @Override
    public Field<OffsetDateTime> field15() {
        return Something.SOMETHING.SOMETIMESTAMPWITHTZ;
    }

    @Override
    public Field<byte[]> field16() {
        return Something.SOMETHING.SOMEBYTEA;
    }

    @Override
    public Field<List<String>> field17() {
        return Something.SOMETHING.SOMESTRINGASLIST;
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
    public Long component3() {
        return getSomehugenumber();
    }

    @Override
    public Short component4() {
        return getSomesmallnumber();
    }

    @Override
    public Integer component5() {
        return getSomeregularnumber();
    }

    @Override
    public Double component6() {
        return getSomedouble();
    }

    @Override
    public Someenum component7() {
        return getSomeenum();
    }

    @Override
    public JsonObject component8() {
        return getSomejsonobject();
    }

    @Override
    public SomeJsonPojo component9() {
        return getSomecustomjsonobject();
    }

    @Override
    public JsonArray component10() {
        return getSomejsonarray();
    }

    @Override
    public JsonObject component11() {
        return getSomevertxjsonobject();
    }

    @Override
    public LocalTime component12() {
        return getSometime();
    }

    @Override
    public LocalDate component13() {
        return getSomedate();
    }

    @Override
    public LocalDateTime component14() {
        return getSometimestamp();
    }

    @Override
    public OffsetDateTime component15() {
        return getSometimestampwithtz();
    }

    @Override
    public byte[] component16() {
        return getSomebytea();
    }

    @Override
    public List<String> component17() {
        return getSomestringaslist();
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
    public Long value3() {
        return getSomehugenumber();
    }

    @Override
    public Short value4() {
        return getSomesmallnumber();
    }

    @Override
    public Integer value5() {
        return getSomeregularnumber();
    }

    @Override
    public Double value6() {
        return getSomedouble();
    }

    @Override
    public Someenum value7() {
        return getSomeenum();
    }

    @Override
    public JsonObject value8() {
        return getSomejsonobject();
    }

    @Override
    public SomeJsonPojo value9() {
        return getSomecustomjsonobject();
    }

    @Override
    public JsonArray value10() {
        return getSomejsonarray();
    }

    @Override
    public JsonObject value11() {
        return getSomevertxjsonobject();
    }

    @Override
    public LocalTime value12() {
        return getSometime();
    }

    @Override
    public LocalDate value13() {
        return getSomedate();
    }

    @Override
    public LocalDateTime value14() {
        return getSometimestamp();
    }

    @Override
    public OffsetDateTime value15() {
        return getSometimestampwithtz();
    }

    @Override
    public byte[] value16() {
        return getSomebytea();
    }

    @Override
    public List<String> value17() {
        return getSomestringaslist();
    }

    @Override
    public SomethingRecord value1(Integer value) {
        setSomeid(value);
        return this;
    }

    @Override
    public SomethingRecord value2(String value) {
        setSomestring(value);
        return this;
    }

    @Override
    public SomethingRecord value3(Long value) {
        setSomehugenumber(value);
        return this;
    }

    @Override
    public SomethingRecord value4(Short value) {
        setSomesmallnumber(value);
        return this;
    }

    @Override
    public SomethingRecord value5(Integer value) {
        setSomeregularnumber(value);
        return this;
    }

    @Override
    public SomethingRecord value6(Double value) {
        setSomedouble(value);
        return this;
    }

    @Override
    public SomethingRecord value7(Someenum value) {
        setSomeenum(value);
        return this;
    }

    @Override
    public SomethingRecord value8(JsonObject value) {
        setSomejsonobject(value);
        return this;
    }

    @Override
    public SomethingRecord value9(SomeJsonPojo value) {
        setSomecustomjsonobject(value);
        return this;
    }

    @Override
    public SomethingRecord value10(JsonArray value) {
        setSomejsonarray(value);
        return this;
    }

    @Override
    public SomethingRecord value11(JsonObject value) {
        setSomevertxjsonobject(value);
        return this;
    }

    @Override
    public SomethingRecord value12(LocalTime value) {
        setSometime(value);
        return this;
    }

    @Override
    public SomethingRecord value13(LocalDate value) {
        setSomedate(value);
        return this;
    }

    @Override
    public SomethingRecord value14(LocalDateTime value) {
        setSometimestamp(value);
        return this;
    }

    @Override
    public SomethingRecord value15(OffsetDateTime value) {
        setSometimestampwithtz(value);
        return this;
    }

    @Override
    public SomethingRecord value16(byte[] value) {
        setSomebytea(value);
        return this;
    }

    @Override
    public SomethingRecord value17(List<String> value) {
        setSomestringaslist(value);
        return this;
    }

    @Override
    public SomethingRecord values(Integer value1, String value2, Long value3, Short value4, Integer value5, Double value6, Someenum value7, JsonObject value8, SomeJsonPojo value9, JsonArray value10, JsonObject value11, LocalTime value12, LocalDate value13, LocalDateTime value14, OffsetDateTime value15, byte[] value16, List<String> value17) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        value16(value16);
        value17(value17);
        return this;
    }

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    @Override
    public void from(ISomething from) {
        setSomeid(from.getSomeid());
        setSomestring(from.getSomestring());
        setSomehugenumber(from.getSomehugenumber());
        setSomesmallnumber(from.getSomesmallnumber());
        setSomeregularnumber(from.getSomeregularnumber());
        setSomedouble(from.getSomedouble());
        setSomeenum(from.getSomeenum());
        setSomejsonobject(from.getSomejsonobject());
        setSomecustomjsonobject(from.getSomecustomjsonobject());
        setSomejsonarray(from.getSomejsonarray());
        setSomevertxjsonobject(from.getSomevertxjsonobject());
        setSometime(from.getSometime());
        setSomedate(from.getSomedate());
        setSometimestamp(from.getSometimestamp());
        setSometimestampwithtz(from.getSometimestampwithtz());
        setSomebytea(from.getSomebytea());
        setSomestringaslist(from.getSomestringaslist());
    }

    @Override
    public <E extends ISomething> E into(E into) {
        into.from(this);
        return into;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SomethingRecord
     */
    public SomethingRecord() {
        super(Something.SOMETHING);
    }

    /**
     * Create a detached, initialised SomethingRecord
     */
    public SomethingRecord(Integer someid, String somestring, Long somehugenumber, Short somesmallnumber, Integer someregularnumber, Double somedouble, Someenum someenum, JsonObject somejsonobject, SomeJsonPojo somecustomjsonobject, JsonArray somejsonarray, JsonObject somevertxjsonobject, LocalTime sometime, LocalDate somedate, LocalDateTime sometimestamp, OffsetDateTime sometimestampwithtz, byte[] somebytea, List<String> somestringaslist) {
        super(Something.SOMETHING);

        setSomeid(someid);
        setSomestring(somestring);
        setSomehugenumber(somehugenumber);
        setSomesmallnumber(somesmallnumber);
        setSomeregularnumber(someregularnumber);
        setSomedouble(somedouble);
        setSomeenum(someenum);
        setSomejsonobject(somejsonobject);
        setSomecustomjsonobject(somecustomjsonobject);
        setSomejsonarray(somejsonarray);
        setSomevertxjsonobject(somevertxjsonobject);
        setSometime(sometime);
        setSomedate(somedate);
        setSometimestamp(sometimestamp);
        setSometimestampwithtz(sometimestampwithtz);
        setSomebytea(somebytea);
        setSomestringaslist(somestringaslist);
    }

    /**
     * Create a detached, initialised SomethingRecord
     */
    public SomethingRecord(generated.classic.reactive.guice.tables.pojos.Something value) {
        super(Something.SOMETHING);

        if (value != null) {
            setSomeid(value.getSomeid());
            setSomestring(value.getSomestring());
            setSomehugenumber(value.getSomehugenumber());
            setSomesmallnumber(value.getSomesmallnumber());
            setSomeregularnumber(value.getSomeregularnumber());
            setSomedouble(value.getSomedouble());
            setSomeenum(value.getSomeenum());
            setSomejsonobject(value.getSomejsonobject());
            setSomecustomjsonobject(value.getSomecustomjsonobject());
            setSomejsonarray(value.getSomejsonarray());
            setSomevertxjsonobject(value.getSomevertxjsonobject());
            setSometime(value.getSometime());
            setSomedate(value.getSomedate());
            setSometimestamp(value.getSometimestamp());
            setSometimestampwithtz(value.getSometimestampwithtz());
            setSomebytea(value.getSomebytea());
            setSomestringaslist(value.getSomestringaslist());
        }
    }

        public SomethingRecord(io.vertx.core.json.JsonObject json) {
                this();
                fromJson(json);
        }
}
