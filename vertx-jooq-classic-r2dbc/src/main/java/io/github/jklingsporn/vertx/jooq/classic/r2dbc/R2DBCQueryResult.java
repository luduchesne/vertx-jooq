package io.github.jklingsporn.vertx.jooq.classic.r2dbc;

import io.github.jklingsporn.vertx.jooq.shared.internal.AbstractQueryResult;
import io.github.jklingsporn.vertx.jooq.shared.internal.QueryResult;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Result;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author jensklingsporn
 */
public class R2DBCQueryResult<R extends Record> extends AbstractQueryResult {

    private final List<R> result;
    private final int index;

    public R2DBCQueryResult( R result) {
        this.index = 0;
        this.result = result == null ? Collections.emptyList() : List.of(result);
    }

    public R2DBCQueryResult(List<R> result, int index) {
        this.result = result;
        this.index = index;
    }


    @Override
    public <T> T get(Field<T> field) {
        return supplyOrThrow(() ->
                                     result.get(index).get(field));
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T get(int index, Class<T> type) {
        return supplyOrThrow(() -> (T) result.get(this.index).get(index));
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T get(String columnName, Class<T> type) {
        return supplyOrThrow(() -> (T) result.get(this.index).get(columnName));
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T unwrap() {
        return (T) result;
    }

    @Override
    public boolean hasResults() {
        return !result.isEmpty();
    }

    @Override
    public Stream<QueryResult> stream() {
        return IntStream
                .range(index, result.size())
                .mapToObj(i -> new R2DBCQueryResult(result, i));
    }
}
