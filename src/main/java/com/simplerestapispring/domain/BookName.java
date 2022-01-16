package com.simplerestapispring.domain;

public class BookName {
    String value;

    public BookName(String value) {
        this.value = value;
    }

    @Deprecated(since = "jackson")
    public String getValue(){return value;}

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
