package com.example.bookapp.repository;

import com.example.bookapp.entity.Book;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface BookRepository extends ListCrudRepository<Book, Long> {

    List<Book> findByTitleContaining(String title);
}