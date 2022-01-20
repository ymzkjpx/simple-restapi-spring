package com.simplerestapispring.domain;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

public record Book(@NotNull BookId bookId,
                   @NotNull(groups = WebRequest.class) BookName bookName,
                   @NotNull(groups = WebRequest.class) LocalDate publishDate) {
    public Book(BookId bookId, BookName bookName, LocalDate publishDate) {
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

    @Override
    public BookId bookId() {
        return bookId;
    }

    @Override
    public BookName bookName() {
        return bookName;
    }

    @Override
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
