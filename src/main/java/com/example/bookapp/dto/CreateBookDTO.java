package com.example.bookapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class CreateBookDTO {

    @NotBlank
    public String title;

    public String description;

    @PastOrPresent
    public LocalDate publishedDate;

    public String author;

    public String isbn;
}