package com.simplerestapispring.domain;

import javax.validation.constraints.NotNull;

public class BookId {
    @NotNull private String value;

    private BookId(String value) {
        this.value = value;
    }

    public static BookId from(String bookId) {
        return new BookId(bookId);
    }

    public String value() {
        return value;
    }
}
