package com.libraryproject.library.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "books")
@EntityListeners(AuditingEntityListener.class)

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private long price ;
    @Column(nullable = false)
     private String title;
    @Column(nullable = false)
    private String availability;
    @Column(nullable = false)
    private String currency;
    @Column(nullable = false)
    private String picture;


    @ManyToOne
    @JoinColumn(name = "book_category_id")
    @OnDelete (action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private BookCategory bookCategory;


    @ManyToOne
    @JoinColumn(name = "promotion_id")
    @OnDelete (action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Promotion promotion;


    @ManyToOne
    @JoinColumn(name = "commande_id")
    @OnDelete (action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Commande commande;

    @ManyToOne
    @JoinColumn(name = "panier_id")
    @OnDelete (action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Panier panier;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author_id", nullable = false)
    @OnDelete (action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Author  author;


    public BookCategory getBookCategory() {
        return bookCategory;
    }
    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }


    public Book() {
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }

    public Book(long price, String title, String availability) {
         this.price = price;
         this.title = title;
        this.availability = availability;
    }

    public Book(long price, String title, String availability, BookCategory bookCategory, Author author) {
        this.price = price;
        this.title = title;
        this.availability = availability;
        this.bookCategory = bookCategory;
        this.author = author;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public long getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public String getAvailability() {
        return availability;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", price=" + price +
                ", title='" + title + '\'' +
                ", availability='" + availability + '\'' +
                ", currency='" + currency + '\'' +
                ", picture='" + picture + '\'' +
                ", bookCategory=" + bookCategory +
                ", promotion=" + promotion +
                ", commande=" + commande +
                ", panier=" + panier +
                ", author=" + author +
                '}';
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}
