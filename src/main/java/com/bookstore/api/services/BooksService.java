package com.bookstore.api.services;

import com.bookstore.api.ResourceNotFoundException;
import com.bookstore.api.models.Book;
import com.bookstore.api.repositories.BooksRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BooksService {

    private BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public Book create(Book book){
        return this.booksRepository.save(book);
    }

    public List<Book> list(){
        Iterable<Book> all = this.booksRepository.findAll();
        List<Book> result = new ArrayList<>();
        for (Book b: all) {
            result.add(b);
        }

        return result;
    }

    public Book findById(Long id) throws ResourceNotFoundException {
        Optional<Book> maybeBook = this.booksRepository.findById(id);
        return maybeBook.orElseThrow(() -> new ResourceNotFoundException("Book " + id + " not found"));
    }

    public Book update(Long id, Book updatedBook) {
        Optional<Book> maybeBook = this.booksRepository.findById(id);
        if (maybeBook.isPresent()) {
            updatedBook.setId(id);
            this.booksRepository.save(updatedBook);
        }

        return updatedBook;
    }
}
