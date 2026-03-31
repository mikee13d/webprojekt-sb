package com.example.bookapp;

import com.example.bookapp.dto.CreateBookDTO;
import com.example.bookapp.entity.Book;
import com.example.bookapp.mapper.BookMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookMapperTest {

    @Test
    void testToEntity() {
        BookMapper mapper = new BookMapper();

        CreateBookDTO dto = new CreateBookDTO();
        dto.title = "Test";

        Book book = mapper.toEntity(dto);

        assertEquals("Test", book.getTitle());
    }
}
