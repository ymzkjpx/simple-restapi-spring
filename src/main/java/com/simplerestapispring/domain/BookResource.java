package com.simplerestapispring.domain;

import java.io.Serializable;
import java.time.LocalDate;

public class BookResource implements Serializable {
    private static final long serializableVersionUID = 1L;

    private final String bookId;
    private final String bookName;
    private final LocalDate publishDate;

    public BookResource(String bookId, String bookName, LocalDate publishDate) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.publishDate = publishDate;
    }

    public static BookResource from(Book book) {
        return new BookResource(book.bookId(), book.bookName(), book.publishDate());
    }
}
