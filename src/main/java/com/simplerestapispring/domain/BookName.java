package com.simplerestapispring.domain;

import javax.validation.constraints.NotNull;

public class BookName {
    @NotNull private String value;

    private BookName(String value) {
        this.value = value;
    }

    public static BookName from(String bookName) {
        return new BookName(bookName);
    }

    @Deprecated(since = "jackson")
    public String getValue() {
        return value;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return "BookName{" +
                "value='" + value + '\'' +
                '}';
    }
}
