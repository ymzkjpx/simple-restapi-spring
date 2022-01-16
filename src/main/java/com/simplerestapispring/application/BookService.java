package com.simplerestapispring.application;

import com.simplerestapispring.domain.Book;
import com.simplerestapispring.domain.BookName;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BookService {
    public Book findBy(String bookId) {
        return Book.from(
                "00000000-0000-0000-0000-000000000000"
                ,  new BookName("some book name")
                , LocalDate.now()
        );
    }
}
