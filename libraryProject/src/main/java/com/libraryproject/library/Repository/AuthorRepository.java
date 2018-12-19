package com.libraryproject.library.Repository;

import com.libraryproject.library.Model.Author;
import com.libraryproject.library.Model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorRepository  extends JpaRepository<Author,Long> {

 }
