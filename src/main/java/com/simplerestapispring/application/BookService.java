package com.simplerestapispring.application;

import com.simplerestapispring.domain.Book;
import com.simplerestapispring.domain.BookId;
import com.simplerestapispring.domain.BookName;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Optional;

@Service
public class BookService {
    public static HashMap<BookId, Book> repository = new HashMap<>();

    private BookService() {
        Book mockBook = mockBook();
        repository.put(mockBook.bookId(), mockBook);
    }

    private Book mockBook() {
        return Book.from(
                BookId.from("00000000-0000-0000-0000-000000000000")
                , BookName.from("銀河鉄道の夜")
                , LocalDate.now()
        );
    }

    public Book findBy(BookId bookId) {
        return repository.get(bookId);
    }

    public Book findBy(BookName bookName) {
        Optional<Book> result = repository.values().stream().filter(book -> book.bookName().equals(bookName)).findFirst();
        return result.orElse(null);
    }

    public void register(Book book) {
        repository.put(book.bookId(), book);
    }
}
