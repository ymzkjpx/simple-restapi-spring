package com.simplerestapispring.presentation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.simplerestapispring.application.BookService;
import com.simplerestapispring.domain.Book;
import com.simplerestapispring.domain.BookId;
import com.simplerestapispring.domain.BookName;
import com.simplerestapispring.domain.BookResource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

@RestController
@RequestMapping("/book")
public class BookController {

    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /*
     * $ curl -X GET http://localhost:8080/book/bookid/00000000-0000-0000-0000-000000000000 | jq
     */
    @RequestMapping(path = "bookid/{bookId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BookResource> findByBookId(@PathVariable String bookId) throws JsonProcessingException {
        Book result = bookService.findBy(BookId.from(bookId));
        if (result == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(BookResource.of(result));
    }

    /*
     * $ curl -X GET http://localhost:8080/book/?book-name=apple | jq
     * $ curl -X GET http://localhost:8080/book/?book-name=suketoudara | jq
     */
    @RequestMapping(path = "", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BookResource> findByBookName(@RequestParam("book-name") String bookName) {
        System.out.println(bookName);
        Book result = bookService.findBy(BookName.from(bookName));
        if (result == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(BookResource.of(result));
    }

    /**
     * $ curl -X POST -H "Content-Type: application/json" -d '{"bookName":"suketoudara", "publishDate":"2022-01-01"}' http://localhost:8080/book/register
     */
    @PostMapping(path = "register")
    @ResponseStatus(HttpStatus.CREATED)
    public void post(@RequestBody BookRequest bookRequest){
        Book book = Book.fromBy(bookRequest.bookName(), bookRequest.publishDate());
        bookService.register(book);
    }
}
