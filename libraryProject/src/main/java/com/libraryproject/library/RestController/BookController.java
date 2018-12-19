package com.libraryproject.library.RestController;

import com.libraryproject.library.Model.Author;
import com.libraryproject.library.Model.Book;
import com.libraryproject.library.Repository.AuthorRepository;
import com.libraryproject.library.Repository.BookCategoryRepository;
import com.libraryproject.library.ServiceLayer.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

 public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookCategoryRepository bookCategoryRepository;


/*
    @RequestMapping(value = "/book/add" ,method = RequestMethod.GET)
    public ResponseEntity addBook () {

        bookService.save(new Book(454,"tiyerlkl",1));

        bookService.save(new Book(444,"tiyl",1));
        return new ResponseEntity("saved", HttpStatus.OK);
    }
*/
    @RequestMapping(path="/book/add",method = RequestMethod.POST)
    public ResponseEntity addBook(@RequestBody   Book bookDetail) {
         bookService.save(bookDetail);
        return new ResponseEntity("book saved", HttpStatus.OK);
    }

    @RequestMapping(path="/book/update",method = RequestMethod.PUT)
    public ResponseEntity updateBook(@RequestBody   Book bookDetail) {
        bookService.save(bookDetail);
        return new ResponseEntity("book updated", HttpStatus.OK);
    }

    @RequestMapping(value = "/book/all" ,method = RequestMethod.GET)
    public ResponseEntity getBook() {
       List<Book> books = bookService.findAll();

        return new ResponseEntity(books, HttpStatus.OK);
      }

    @RequestMapping(value = "/book/allAvailable" ,method = RequestMethod.GET)
    public ResponseEntity getBookAvailable() {
        List<Book> books = bookService.findByAvailability("1");

        return new ResponseEntity(books, HttpStatus.OK);
    }


    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public ResponseEntity getBook(@PathVariable  (name = "id", value = "id")  Long id) {
        Optional<Book> book = bookService.findById(id);
        return new ResponseEntity(book, HttpStatus.OK);
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteBook(@PathVariable(name = "id", value = "id") Long id) {
        bookService.deleteById(id);
        return new ResponseEntity("book deleted ", HttpStatus.OK);
    }


    @GetMapping("/author/{authorId}/books")
    public List<Book> getAllBooksByPostId(@PathVariable   (value = "authorId") Long authorId) {
        return bookService.findByAuthorId(authorId);
    }
    @GetMapping("/bookCategory/{bookCategoryId}/books")
    public List<Book> getAllBooksByBookCategoryId(@PathVariable   (value = "bookCategoryId") Long bookCategoryId) {
        return bookService.findByBookCategoryId(bookCategoryId);
    }

    @PostMapping("/author/{authorId}/bookCategory/{bookCategoryID}/books")
    public Book createBook(@PathVariable (value = "authorId") Long authorId,@PathVariable (value = "bookCategoryID") Long bookCategoryID,
                           @Valid  @RequestBody Book book) {
        book.setAuthor(authorRepository.findById(authorId).get());
        book.setBookCategory(bookCategoryRepository.findById(bookCategoryID).get());
        bookService.save(book);
         return book;
     }



      /*
    @RequestMapping(path="/book/add",method = RequestMethod.POST)
    public ResponseEntity addBook(@RequestBody Book bookDetail) {
        Book bookToSave =new Book(bookDetail.getPrice(),bookDetail.getTitle(),bookDetail.getAvailability());
        bookService.save(bookToSave);
        return new ResponseEntity("book saved", HttpStatus.OK);
    }
*/
/*




    @RequestMapping(value = "/title/{title:.+}", method = RequestMethod.GET)
    public ResponseEntity findByTitle(@PathVariable(name = "title", value = "title") String title) {

        List<Book> books = bookService.findByTitle(title);
        return new ResponseEntity(books, HttpStatus.OK);
    }



    ---- */
    /* @RequestMapping(value = "/add/{id}/{title}/{author}/{price}/{bookCategory}")
    public Book addBook(@PathVariable  long id, @PathVariable String name, @PathVariable Author author,
                           @PathVariable long price, @PathVariable BookCategory bookCategory) {
        Book book = new Book();
        book.setId(id);
        book.setTitle(name);
        book.setAuthor(author);
        book.setPrice(price);
        book.setBookCategory(bookCategory);
        bookService.saveBook(book);
        return book;
    }*/


    /*@RequestMapping(value = "/search/price/{price}")
    public List<Book> getBookByPrice(@PathVariable int price) {
        List<Book> books = bookService.findByPrice(price);
        return books;
    }

    @RequestMapping(value = "/search/bookCategory/{bookCategory}")
    public List<Book> getBookByBookCategory(@PathVariable BookCategory bookCategory) {
        List<Book> books = bookService.findByBookCategory(bookCategory);
        return books;
    }

    @RequestMapping(value = "/search/{title}/{author}")
    public List<Book> getBookByNameAndAuthor(@PathVariable String title, @PathVariable Author author) {
        List<Book> books = bookService.findByTitleAndAuthor(title, author);
        return books;
    }*/
}
