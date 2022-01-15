package com.simplerestapispring.domain;

import org.springframework.lang.NonNull;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

public class Book {
    @NonNull String bookId;
    @NotNull String bookName;
    @NotNull LocalDate publishDate;

    private Book(String bookId, String bookName, LocalDate publishDate) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.publishDate = publishDate;
    }

    public static Book from(String bookId, String bookName, LocalDate publishDate){
        return new Book(bookId, bookName, publishDate);
    }

    public String bookId() {
        return bookId;
    }

    public String bookName() {
        return bookName;
    }

    public LocalDate publishDate() {
        return publishDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", publishDate=" + publishDate +
                '}';
    }
}
