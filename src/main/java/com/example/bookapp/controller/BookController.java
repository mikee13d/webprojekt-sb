package com.example.bookapp.controller;

import com.example.bookapp.dto.*;
import com.example.bookapp.entity.Book;
import com.example.bookapp.service.BookService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("books", service.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String form(Model model) {
        model.addAttribute("book", new CreateBookDTO());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("book") CreateBookDTO dto,
                         BindingResult result) {
        if (result.hasErrors()) return "create";

        service.create(dto);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Book b = service.get(id);

        UpdateBookDTO dto = new UpdateBookDTO();
        dto.setId(b.getId());
        dto.setTitle(b.getTitle());
        dto.setDescription(b.getDescription());
        dto.setPublishedDate(b.getPublishedDate());
        dto.setAuthor(b.getAuthor());
        dto.setIsbn(b.getIsbn());

        model.addAttribute("book", dto);
        return "edit";
    }

    @PostMapping("/edit")
    public String update(@Valid @ModelAttribute("book") UpdateBookDTO dto,
                         BindingResult result) {

        if (result.hasErrors()) return "edit";

        service.update(dto);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/books";
    }
}