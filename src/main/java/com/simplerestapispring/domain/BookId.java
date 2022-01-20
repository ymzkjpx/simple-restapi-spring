package com.simplerestapispring.domain;

import java.util.Objects;
import java.util.UUID;

import javax.validation.constraints.NotNull;

public class BookId {
    @NotNull private final String value;

    private BookId(String value) {
        this.value = value;
    }

    public static BookId from(String bookId) {
        return new BookId(bookId);
    }

    public static BookId generate() {
        return new BookId(UUID.randomUUID().toString());
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookId)) return false;
        BookId bookId = (BookId) o;
        return Objects.equals(value, bookId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

