package com.example.bookapp.mapper;

import com.example.bookapp.dto.CreateBookDTO;
import com.example.bookapp.dto.UpdateBookDTO;
import com.example.bookapp.dto.BookDTO;
import com.example.bookapp.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    // ✅ Entity → DTO (for list view)
    public BookDTO toDTO(Book b) {
        BookDTO dto = new BookDTO();
        dto.id = b.getId();
        dto.title = b.getTitle();
        dto.author = b.getAuthor();
        dto.description = b.getDescription();
        dto.isbn = b.getIsbn();
        dto.publishedDate = b.getPublishedDate();
        return dto;
    }

    // ✅ Create DTO → Entity
    public Book toEntity(CreateBookDTO dto) {
        Book b = new Book();
        b.setTitle(dto.getTitle());
        b.setAuthor(dto.getAuthor());
        b.setDescription(dto.getDescription());
        b.setIsbn(dto.getIsbn());
        b.setPublishedDate(dto.getPublishedDate());
        return b;
    }

    // ✅ Update existing Entity
    public void update(UpdateBookDTO dto, Book b) {
        b.setTitle(dto.getTitle());
        b.setAuthor(dto.getAuthor());
        b.setDescription(dto.getDescription());
        b.setIsbn(dto.getIsbn());
        b.setPublishedDate(dto.getPublishedDate());
    }
}