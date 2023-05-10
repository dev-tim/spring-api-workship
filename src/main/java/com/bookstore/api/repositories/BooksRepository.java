package com.bookstore.api.repositories;

import com.bookstore.api.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BooksRepository extends CrudRepository<Book, Long> {
}
