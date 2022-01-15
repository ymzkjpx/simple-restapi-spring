package com.simplerestapispring.presentation;

import com.simplerestapispring.application.BookService;
import com.simplerestapispring.domain.Book;
import com.simplerestapispring.domain.BookResource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(path = "{bookId}", method = RequestMethod.GET, produces ="application/json")
    public BookResource find(@PathVariable String bookId){
        Book book = bookService.findBy(bookId);
        return new BookResource(book.bookId(), book.bookName(), book.publishDate());
//        return BookResource.from(book);
    }

}
