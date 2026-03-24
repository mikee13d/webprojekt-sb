package com.example.bookapp.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class UpdateBookDTO {

    public Long id;

    @NotBlank
    public String title;

    public String description;

    public LocalDate publishedDate;

    public String author;

    public String isbn;
}