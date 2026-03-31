package com.example.bookapp;

import com.example.bookapp.dto.CreateBookDTO;
import com.example.bookapp.mapper.BookMapper;
import com.example.bookapp.repository.BookRepository;
import com.example.bookapp.service.BookService;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class BookServiceTest {

    @Test
    void testCreate() {
        BookRepository repo = mock(BookRepository.class);
        BookMapper mapper = new BookMapper();

        BookService service = new BookService(repo, mapper);

        CreateBookDTO dto = new CreateBookDTO();
        dto.title = "Test Book";

        service.create(dto);

        verify(repo, times(1)).save(any());
    }
}