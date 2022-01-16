package com.simplerestapispring.domain;

import org.springframework.lang.NonNull;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

public class Book{
    private @NonNull String bookId;
    private @NotNull BookName bookName;
    private @NotNull LocalDate publishDate;

    private Book(String bookId, BookName bookName, LocalDate publishDate) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.publishDate = publishDate;
    }

    public static Book from(String bookId, BookName bookName, LocalDate publishDate) {
        return new Book(bookId, bookName, publishDate);
    }

    @Deprecated(since = "jackson")
    public String getBookId() {
        return bookId;
    }

    @Deprecated(since = "jackson")
    public BookName getBookName() {
        return bookName;
    }

    @Deprecated(since = "jackson")
    public LocalDate getPublishDate() {
        return publishDate;
    }

    public String bookId(){return bookId;}
    public BookName bookName(){return bookName;}
    public LocalDate publishDate(){return publishDate;}

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", publishDate=" + publishDate +
                '}';
    }
}
