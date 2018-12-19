package com.libraryproject.library.Repository;

import com.libraryproject.library.Model.Book;
import com.libraryproject.library.Model.BookCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface BookCategoryRepository extends JpaRepository<BookCategory,Long> {

}
