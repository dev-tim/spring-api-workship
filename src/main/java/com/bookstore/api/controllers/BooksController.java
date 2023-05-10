package com.bookstore.api.controllers;

import com.bookstore.api.ResourceNotFoundException;
import com.bookstore.api.models.Book;
import com.bookstore.api.services.BooksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    private BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @PostMapping
    public Book create(@RequestBody Book book){
        return this.booksService.create(book);
    }

    @GetMapping
    public List<Book> lists() {
        return this.booksService.list();

    }

    // 200 OK + Body
    // 404 Not Found + Error message
    @GetMapping("{id}")
    public Book get(@PathVariable Long id) throws ResourceNotFoundException {
        return this.booksService.findById(id);
    }

    @PutMapping("{id}")
    public Book update(@PathVariable Long id, @RequestBody Book updatedBook) {
        return this.booksService.update(id, updatedBook);
    }

    public void delete(Long id) {

    }

    @ExceptionHandler()
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }
}
