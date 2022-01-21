package com.simplerestapispring.presentation.view.book;

import com.simplerestapispring.domain.BookName;

import java.time.LocalDate;

/**
 * @DoNotUse 現在使われておりません。
 * WebRequestアノテーションを利用した応用技によって、本クラスは不要になった。
 */
public class BookRequest {
    BookName bookName;
    LocalDate publishDate;

    public BookRequest(BookName bookName, LocalDate publishDate) {
        this.bookName = bookName;
        this.publishDate = publishDate;
    }

    public BookName bookName() {
        return bookName;
    }

    public LocalDate publishDate() {
        return publishDate;
    }
}
