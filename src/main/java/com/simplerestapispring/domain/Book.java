package com.simplerestapispring.domain;

import org.springframework.lang.NonNull;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

public class Book {
    private final @NonNull BookId bookId;
    private final @NotNull BookName bookName;
    private final @NotNull LocalDate publishDate;

    private Book(BookId bookId, BookName bookName, LocalDate publishDate) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.publishDate = publishDate;
    }

    public static Book from(BookId bookId, BookName bookName, LocalDate publishDate) {
        return new Book(bookId, bookName, publishDate);
    }

    public static Book fromBy(BookName bookName, LocalDate publishDate) {
        return new Book(BookId.generate(), bookName, publishDate);
    }

    public BookId getBookId() {
        return bookId;
    }

    public BookName getBookName() {
        return bookName;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public BookId bookId() {
        return bookId;
    }

    public BookName bookName() {
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
