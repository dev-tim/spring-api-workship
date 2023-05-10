package com.bookstore.api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Book {

    @Id
    private Long id;
    private String title;
    private LocalDate publishDate;
    private String author;

    public Book(Long id, String title, LocalDate publishDate, String author) {
        this.id = id;
        this.title = title;
        this.publishDate = publishDate;
        this.author = author;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publishDate=" + publishDate +
                ", author='" + author + '\'' +
                '}';
    }
}
