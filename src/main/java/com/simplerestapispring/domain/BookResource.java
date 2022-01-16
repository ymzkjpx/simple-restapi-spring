package com.simplerestapispring.domain;

import java.io.Serializable;
import java.time.LocalDate;

public record BookResource(String bookId, String bookName, LocalDate publishDate)
        implements Serializable {
    private static final long serializableVersionUID = 1L;

    public static BookResource from(Book book) {
        return new BookResource(book.bookId(), book.bookName().value(), book.publishDate());
    }
}
