package com.students.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.students.info.entity.Book;
import com.students.info.security.SecuredRestController;
import com.students.info.service.BookService;

@RestController
@RequestMapping(value = "/book")
public class BookController implements SecuredRestController {
    @Autowired
    private BookService bookService;
    @RequestMapping(value = "/book", method = RequestMethod.POST)
    @ResponseBody
    public Book saveBook(@RequestBody Book book) {
        Book bookResponse = bookService.saveBook(book);
        return bookResponse;
    }
    @RequestMapping(value = "/book/{bookId}", method = RequestMethod.GET)
    @ResponseBody
    public Book getBookDetails(@PathVariable int bookId) {
        Book bookResponse = bookService.findByBookId(bookId);
        return bookResponse;
    }
}