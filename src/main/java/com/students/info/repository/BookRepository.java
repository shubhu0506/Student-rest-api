package com.students.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.students.info.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    public Book findByBookId(int bookId);
}