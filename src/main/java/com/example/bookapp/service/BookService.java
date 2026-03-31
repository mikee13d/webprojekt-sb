package com.example.bookapp.service;

import com.example.bookapp.dto.*;
import com.example.bookapp.entity.Book;
import com.example.bookapp.exception.ResourceNotFoundException;
import com.example.bookapp.mapper.BookMapper;
import com.example.bookapp.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class BookService {

    private final BookRepository repo;
    private final BookMapper mapper;

    public BookService(BookRepository repo, BookMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public List<BookDTO> findAll() {
        return StreamSupport.stream(repo.findAll().spliterator(), false)
                .map(mapper::toDTO)
                .toList();
    }

    public void create(CreateBookDTO dto) {
        if ("test".equalsIgnoreCase(dto.getTitle())) {
            throw new IllegalArgumentException("Title cannot be 'test'");
        }
        repo.save(mapper.toEntity(dto));
    }

    public Book get(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));
    }

    public void update(UpdateBookDTO dto) {
        Book b = get(dto.getId());
        mapper.update(dto, b);
        repo.save(b);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}