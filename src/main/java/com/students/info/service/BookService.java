package com.students.info.service;

import org.springframework.stereotype.Component;

import com.students.info.entity.Book;

@Component
public interface BookService {
    public Book saveBook(Book book);
    public Book findByBookId(int bookId);
}