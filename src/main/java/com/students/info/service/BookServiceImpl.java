package com.students.info.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.info.entity.Book;
import com.students.info.entity.Story;
import com.students.info.repo.BookRepo;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepo bookRepository;
    public Book saveBook(Book book) {
        Story story = book.getStory();
        story.setBook(book);
        book = bookRepository.save(book);
        return book;
    }
    public Book findByBookId(int bookId) {
        Book book = bookRepository.findByBookId(bookId);
        return book;
    }
}