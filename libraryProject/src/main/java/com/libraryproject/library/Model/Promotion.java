package com.libraryproject.library.Model;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "promotions")
@EntityListeners(AuditingEntityListener.class)

public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private Date dateStartPromo ;
    @Column
    private Date dateEndPromo ;
    @Column
    private int value ;
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "promotion")
    private Set<Book> books = new HashSet<>();
public  Promotion (){}
    public Promotion(Date dateStartPromo, Date dateEndPromo, int value, Set<Book> books) {
        this.dateStartPromo = dateStartPromo;
        this.dateEndPromo = dateEndPromo;
        this.value = value;
     }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateStartPromo() {
        return dateStartPromo;
    }

    public void setDateStartPromo(Date dateStartPromo) {
        this.dateStartPromo = dateStartPromo;
    }

    public Date getDateEndPromo() {
        return dateEndPromo;
    }

    public void setDateEndPromo(Date dateEndPromo) {
        this.dateEndPromo = dateEndPromo;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "id=" + id +
                ", dateStartPromo=" + dateStartPromo +
                ", dateEndPromo=" + dateEndPromo +
                ", value=" + value +
                 '}';
    }



}
