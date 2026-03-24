package com.example.bookapp.mapper;

import com.example.bookapp.dto.*;
import com.example.bookapp.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public Book toEntity(CreateBookDTO dto) {
        Book b = new Book();
        b.setTitle(dto.title);
        b.setDescription(dto.description);
        b.setPublishedDate(dto.publishedDate);
        b.setAuthor(dto.author);
        b.setIsbn(dto.isbn);
        return b;
    }

    public void update(UpdateBookDTO dto, Book b) {
        b.setTitle(dto.title);
        b.setDescription(dto.description);
        b.setPublishedDate(dto.publishedDate);
        b.setAuthor(dto.author);
        b.setIsbn(dto.isbn);
    }

    public BookDTO toDTO(Book b) {
        BookDTO dto = new BookDTO();
        dto.id = b.getId();
        dto.title = b.getTitle();
        dto.description = b.getDescription();
        dto.publishedDate = b.getPublishedDate();
        dto.author = b.getAuthor();
        dto.isbn = b.getIsbn();
        return dto;
    }
}