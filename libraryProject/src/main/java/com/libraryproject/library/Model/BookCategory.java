package com.libraryproject.library.Model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "bookCategories")
@EntityListeners(AuditingEntityListener.class)

public class BookCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String category;


    @OneToMany(mappedBy = "bookCategory", cascade = CascadeType.ALL)
    private List<Book> books;

    protected BookCategory() {
    }

    public BookCategory(String category, Set<Book> books) {
        this.category = category;
     }

    public BookCategory(String category, List<Book> books) {
        this.category = category;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }


    @Override
    public String toString() {
        return "BookCategory{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", books=" + books +
                '}';
    }
}
