/*
 * This file is generated by jOOQ.
 */
package generated.rx.reactive.guice.tables.interfaces;


import generated.rx.reactive.guice.enums.Someenum;

import io.github.jklingsporn.vertx.jooq.generate.converter.SomeJsonPojo;
import io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.List;


import static io.github.jklingsporn.vertx.jooq.shared.internal.VertxPojo.*;
/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public interface ISomething extends VertxPojo, Serializable {

    /**
     * Setter for <code>vertx.something.someId</code>.
     */
    public ISomething setSomeid(Integer value);

    /**
     * Getter for <code>vertx.something.someId</code>.
     */
    public Integer getSomeid();

    /**
     * Setter for <code>vertx.something.someString</code>.
     */
    public ISomething setSomestring(String value);

    /**
     * Getter for <code>vertx.something.someString</code>.
     */
    public String getSomestring();

    /**
     * Setter for <code>vertx.something.someHugeNumber</code>.
     */
    public ISomething setSomehugenumber(Long value);

    /**
     * Getter for <code>vertx.something.someHugeNumber</code>.
     */
    public Long getSomehugenumber();

    /**
     * Setter for <code>vertx.something.someSmallNumber</code>.
     */
    public ISomething setSomesmallnumber(Short value);

    /**
     * Getter for <code>vertx.something.someSmallNumber</code>.
     */
    public Short getSomesmallnumber();

    /**
     * Setter for <code>vertx.something.someRegularNumber</code>.
     */
    public ISomething setSomeregularnumber(Integer value);

    /**
     * Getter for <code>vertx.something.someRegularNumber</code>.
     */
    public Integer getSomeregularnumber();

    /**
     * Setter for <code>vertx.something.someDouble</code>.
     */
    public ISomething setSomedouble(Double value);

    /**
     * Getter for <code>vertx.something.someDouble</code>.
     */
    public Double getSomedouble();

    /**
     * Setter for <code>vertx.something.someEnum</code>.
     */
    public ISomething setSomeenum(Someenum value);

    /**
     * Getter for <code>vertx.something.someEnum</code>.
     */
    public Someenum getSomeenum();

    /**
     * Setter for <code>vertx.something.someJsonObject</code>.
     */
    public ISomething setSomejsonobject(JsonObject value);

    /**
     * Getter for <code>vertx.something.someJsonObject</code>.
     */
    public JsonObject getSomejsonobject();

    /**
     * Setter for <code>vertx.something.someCustomJsonObject</code>.
     */
    public ISomething setSomecustomjsonobject(SomeJsonPojo value);

    /**
     * Getter for <code>vertx.something.someCustomJsonObject</code>.
     */
    public SomeJsonPojo getSomecustomjsonobject();

    /**
     * Setter for <code>vertx.something.someJsonArray</code>.
     */
    public ISomething setSomejsonarray(JsonArray value);

    /**
     * Getter for <code>vertx.something.someJsonArray</code>.
     */
    public JsonArray getSomejsonarray();

    /**
     * Setter for <code>vertx.something.someVertxJsonObject</code>.
     */
    public ISomething setSomevertxjsonobject(JsonObject value);

    /**
     * Getter for <code>vertx.something.someVertxJsonObject</code>.
     */
    public JsonObject getSomevertxjsonobject();

    /**
     * Setter for <code>vertx.something.someTime</code>.
     */
    public ISomething setSometime(LocalTime value);

    /**
     * Getter for <code>vertx.something.someTime</code>.
     */
    public LocalTime getSometime();

    /**
     * Setter for <code>vertx.something.someDate</code>.
     */
    public ISomething setSomedate(LocalDate value);

    /**
     * Getter for <code>vertx.something.someDate</code>.
     */
    public LocalDate getSomedate();

    /**
     * Setter for <code>vertx.something.someTimestamp</code>.
     */
    public ISomething setSometimestamp(LocalDateTime value);

    /**
     * Getter for <code>vertx.something.someTimestamp</code>.
     */
    public LocalDateTime getSometimestamp();

    /**
     * Setter for <code>vertx.something.someTimestampWithTZ</code>.
     */
    public ISomething setSometimestampwithtz(OffsetDateTime value);

    /**
     * Getter for <code>vertx.something.someTimestampWithTZ</code>.
     */
    public OffsetDateTime getSometimestampwithtz();

    /**
     * Setter for <code>vertx.something.someByteA</code>.
     */
    public ISomething setSomebytea(byte[] value);

    /**
     * Getter for <code>vertx.something.someByteA</code>.
     */
    public byte[] getSomebytea();

    /**
     * Setter for <code>vertx.something.someStringAsList</code>.
     */
    public ISomething setSomestringaslist(List<String> value);

    /**
     * Getter for <code>vertx.something.someStringAsList</code>.
     */
    public List<String> getSomestringaslist();

    // -------------------------------------------------------------------------
    // FROM and INTO
    // -------------------------------------------------------------------------

    /**
     * Load data from another generated Record/POJO implementing the common
     * interface ISomething
     */
    public void from(ISomething from);

    /**
     * Copy data into another generated Record/POJO implementing the common
     * interface ISomething
     */
    public <E extends ISomething> E into(E into);

        @Override
        public default ISomething fromJson(io.vertx.core.json.JsonObject json) {
                setOrThrow(this::setSomeid,json::getInteger,"someId","java.lang.Integer");
                setOrThrow(this::setSomestring,json::getString,"someString","java.lang.String");
                setOrThrow(this::setSomehugenumber,json::getLong,"someHugeNumber","java.lang.Long");
                setOrThrow(this::setSomesmallnumber,key -> {Integer i = json.getInteger(key); return i==null?null:i.shortValue();},"someSmallNumber","java.lang.Short");
                setOrThrow(this::setSomeregularnumber,json::getInteger,"someRegularNumber","java.lang.Integer");
                setOrThrow(this::setSomedouble,json::getDouble,"someDouble","java.lang.Double");
                setOrThrow(this::setSomeenum,key -> java.util.Arrays.stream(generated.rx.reactive.guice.enums.Someenum.values()).filter(td -> td.getLiteral().equals(json.getString(key))).findFirst().orElse(null),"someEnum","generated.rx.reactive.guice.enums.Someenum");
                setOrThrow(this::setSomejsonobject,json::getJsonObject,"someJsonObject","io.vertx.core.json.JsonObject");
                setSomecustomjsonobject(generated.rx.reactive.guice.tables.converters.Converters.IO_GITHUB_JKLINGSPORN_VERTX_JOOQ_GENERATE_CONVERTER_SOMEJSONPOJOCONVERTER_INSTANCE.pgConverter().from(json.getJsonObject("someCustomJsonObject")));
                setOrThrow(this::setSomejsonarray,json::getJsonArray,"someJsonArray","io.vertx.core.json.JsonArray");
                setSomevertxjsonobject(generated.rx.reactive.guice.tables.converters.Converters.IO_GITHUB_JKLINGSPORN_VERTX_JOOQ_SHARED_POSTGRES_JSONBTOJSONOBJECTCONVERTER_INSTANCE.pgConverter().from(json.getJsonObject("someVertxJsonObject")));
                setOrThrow(this::setSometime,key -> {String s = json.getString(key); return s==null?null:java.time.LocalTime.parse(s);},"someTime","java.time.LocalTime");
                setOrThrow(this::setSomedate,key -> {String s = json.getString(key); return s==null?null:java.time.LocalDate.parse(s);},"someDate","java.time.LocalDate");
                setOrThrow(this::setSometimestamp,key -> {String s = json.getString(key); return s==null?null:java.time.LocalDateTime.parse(s);},"someTimestamp","java.time.LocalDateTime");
                setOrThrow(this::setSometimestampwithtz,key -> {String s = json.getString(key); return s==null?null:java.time.OffsetDateTime.parse(s);},"someTimestampWithTZ","java.time.OffsetDateTime");
                setOrThrow(this::setSomebytea,json::getBinary,"someByteA","byte[]");
                setOrThrow(this::setSomestringaslist,key -> {io.vertx.core.json.JsonArray arr = json.getJsonArray(key); return arr==null?null:new java.util.ArrayList<String>(arr.getList());},"someStringAsList","java.util.List<String>");
                return this;
        }


        @Override
        public default io.vertx.core.json.JsonObject toJson() {
                io.vertx.core.json.JsonObject json = new io.vertx.core.json.JsonObject();
                json.put("someId",getSomeid());
                json.put("someString",getSomestring());
                json.put("someHugeNumber",getSomehugenumber());
                json.put("someSmallNumber",getSomesmallnumber());
                json.put("someRegularNumber",getSomeregularnumber());
                json.put("someDouble",getSomedouble());
                json.put("someEnum",getSomeenum()==null?null:getSomeenum().getLiteral());
                json.put("someJsonObject",getSomejsonobject());
                json.put("someCustomJsonObject",generated.rx.reactive.guice.tables.converters.Converters.IO_GITHUB_JKLINGSPORN_VERTX_JOOQ_GENERATE_CONVERTER_SOMEJSONPOJOCONVERTER_INSTANCE.pgConverter().to(getSomecustomjsonobject()));
                json.put("someJsonArray",getSomejsonarray());
                json.put("someVertxJsonObject",generated.rx.reactive.guice.tables.converters.Converters.IO_GITHUB_JKLINGSPORN_VERTX_JOOQ_SHARED_POSTGRES_JSONBTOJSONOBJECTCONVERTER_INSTANCE.pgConverter().to(getSomevertxjsonobject()));
                json.put("someTime",getSometime()==null?null:getSometime().toString());
                json.put("someDate",getSomedate()==null?null:getSomedate().toString());
                json.put("someTimestamp",getSometimestamp()==null?null:getSometimestamp().toString());
                json.put("someTimestampWithTZ",getSometimestampwithtz()==null?null:getSometimestampwithtz().toString());
                json.put("someByteA",getSomebytea());
                json.put("someStringAsList",getSomestringaslist()==null?null: new io.vertx.core.json.JsonArray(getSomestringaslist()));
                return json;
        }

}
