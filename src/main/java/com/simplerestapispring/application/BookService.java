package com.simplerestapispring.application;

import com.simplerestapispring.domain.Book;
import com.simplerestapispring.domain.BookId;
import com.simplerestapispring.domain.BookName;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BookService {
    public Book findBy(BookId bookId) {
        // Mock method
        return Book.from(
                "00000000-0000-0000-0000-000000000000"
                , BookName.from("Book id method")
                , LocalDate.now()
        );
    }

    public Book findBy(BookName bookName) {
        return Book.from(
                "00000000-0000-0000-0000-000000000001"
                , BookName.from("Book name method")
                , LocalDate.now()
        );
    }
}
