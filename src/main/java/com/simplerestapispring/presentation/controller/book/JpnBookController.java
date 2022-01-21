package com.simplerestapispring.presentation.controller.book;

import com.simplerestapispring.application.BookService;
import com.simplerestapispring.presentation.view.book.お問い合わせ登録依頼型;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/book/jpn-book")
public class JpnBookController {

    BookService bookService;

    public JpnBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public String index() {
        return "book/jpn-book";
    }

    @RequestMapping(path = "", method = RequestMethod.POST, produces = "application/json")
    public String findByBookName(@RequestBody @Valid お問い合わせ登録依頼型 お問い合わせ登録依頼) {
        System.out.println(お問い合わせ登録依頼);
        return "redirect:";
    }
}
