package com.libraryproject.library.Repository;


 import com.libraryproject.library.Model.Book;
 import org.springframework.data.domain.Page;
 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.data.repository.CrudRepository;

  import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
public void deleteById(Long id);
public List<Book> findByAvailability(String a);
public List<Book> findByBookCategoryId(Long bookCategory);
public List<Book> findByAuthorId(Long authorId);
public List<Book> findByPanierId(Long panierId);
  }
