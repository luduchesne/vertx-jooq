package io.github.jklingsporn.vertx.jooq.generate.converter;

import org.jooq.ContextConverter;
import org.jooq.Converter;
import org.jooq.ConverterContext;
import org.jooq.JSONB;

import generated.classic.reactive.regular.tables.pojos.Book;
import generated.classic.reactive.regular.tables.records.BookRecord;
import io.github.jklingsporn.vertx.jooq.shared.postgres.JSONBToJsonPojoConverter;
import io.github.jklingsporn.vertx.jooq.shared.postgres.PgConverter;
import io.github.jklingsporn.vertx.jooq.shared.postgres.RowConverter;
import io.vertx.core.json.JsonObject;

/**
 * @author jensklingsporn
 */
public class BookConverter implements ContextConverter<BookRecord, Book> {


    @Override
    public Book from(BookRecord bookRecord, ConverterContext converterContext) {
        return new Book(bookRecord);
    }

    @Override
    public BookRecord to(Book book, ConverterContext converterContext) {
        return new BookRecord(book);
    }

    @Override
    public  Class<BookRecord> fromType() {
        return BookRecord.class;
    }

    @Override
    public Class<Book> toType() {
        return Book.class;
    }
}
