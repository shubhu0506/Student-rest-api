package com.students.info.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.students.info.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, String> {
    public Book findByBookId(int bookId);
}