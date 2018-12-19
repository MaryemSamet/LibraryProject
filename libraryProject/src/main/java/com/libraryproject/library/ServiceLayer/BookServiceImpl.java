package com.libraryproject.library.ServiceLayer;

 import com.libraryproject.library.Model.Book;
 import com.libraryproject.library.Repository.AuthorRepository;
 import com.libraryproject.library.Repository.BookRepository;
 import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.stereotype.Service;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.PathVariable;

 import javax.transaction.Transactional;
  import java.util.List;
 import java.util.Optional;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
     private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository ;

    public List<Book> findAll(){
        return (List<Book>) bookRepository.findAll();
    }
    public void save(Book book){
        bookRepository.save(book);
    }

    @Override
    public List<Book> findByAvailability(String  a) {
        return bookRepository.findByAvailability(a);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return (bookRepository.findById(id));
     }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);

    }

    @Override
    public List<Book> findByAuthorId(Long authorId) {
        return bookRepository.findByAuthorId(authorId);
    }

    @Override
    public List<Book> findByBookCategoryId(Long bookCategory) {
        return bookRepository.findByBookCategoryId(bookCategory);
    }

/*
    @GetMapping("/author/{authorId}/books")
    public Page<Book> getAllBooksByPostId(@PathVariable   (value = "authorId") Long authorId,
                                             Pageable pageable) {
        return authorRepository.findByAuthorID(authorId, pageable);
    }
*/


}
