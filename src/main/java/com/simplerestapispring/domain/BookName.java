package com.simplerestapispring.domain;

import java.util.Objects;

import javax.validation.constraints.NotNull;

public class BookName {
    @NotNull private final String value;

    private BookName(String value) {
        this.value = value;
    }

    public static BookName from(String bookName) {
        return new BookName(bookName);
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookName)) return false;
        BookName bookName = (BookName) o;
        return Objects.equals(getValue(), bookName.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
