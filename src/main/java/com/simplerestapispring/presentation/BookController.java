package com.simplerestapispring.presentation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.simplerestapispring.application.BookService;
import com.simplerestapispring.domain.Book;
import com.simplerestapispring.domain.BookId;
import com.simplerestapispring.domain.BookName;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/book")
public class BookController {

    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /*
     * $ curl -X GET http://localhost:8080/book/bookid/000 | jq
     */
    @RequestMapping(path = "bookid/{bookId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String findByBookId(@PathVariable String bookId) throws JsonProcessingException {
        Book book = bookService.findBy(BookId.from(bookId));

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        ObjectMapper mapper = Jackson2ObjectMapperBuilder
                .json()
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .modules(new JavaTimeModule())
                .dateFormat(dateFormatter)
                .build();

        String result = mapper.writeValueAsString(book);
//        String result = mapper.writeValueAsString(BookResource.from(book));
        return result;
    }

    @RequestMapping(path = "bookname/{bookName}", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Book findByBookName(@PathVariable("bookName") String bookName){
        Book book = bookService.findBy(BookName.from(bookName));
        return book;
    }
}
