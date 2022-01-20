package com.simplerestapispring.presentation;

import com.simplerestapispring.domain.BookName;

import java.time.LocalDate;

public class BookRequest {
    String bookName;
    LocalDate publishDate;

    public BookRequest(String bookName, LocalDate publishDate) {
        this.bookName = bookName;
        this.publishDate = publishDate;
    }

    public BookName bookName() {
        return BookName.from(bookName);
    }

    public LocalDate publishDate() {
        return publishDate;
    }
}
