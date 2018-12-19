package com.libraryproject.library.ServiceLayer;



import com.libraryproject.library.Model.Book;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface BookService {
    public List<Book> findAll();
    public void save(Book book);
    public List<Book> findByAvailability(String a);
    public Optional<Book> findById(Long id);
    public void deleteById(Long id);
   public List<Book> findByAuthorId(Long authorId);
   public List<Book> findByBookCategoryId(Long bookCategory);

}
