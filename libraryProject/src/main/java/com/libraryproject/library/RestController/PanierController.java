package com.libraryproject.library.RestController;

import com.libraryproject.library.Model.Commande;
import com.libraryproject.library.Model.Panier;
import com.libraryproject.library.Repository.BookRepository;
import com.libraryproject.library.Repository.CommandeRepository;
import com.libraryproject.library.Repository.CustomerRepository;
import com.libraryproject.library.Repository.PanierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController

public class PanierController {


     @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PanierRepository panierRepository;




    @PostMapping("/customer/{customerId}")
    public Panier initialiserPanier(@PathVariable(value = "customerId") Long customerId,
                                        @Valid @RequestBody Panier panier) {
        panier.setCustomer((customerRepository.findById(customerId).get()));
        panierRepository.save(panier);
        return panier;
    }

    @PutMapping("/panier/{panierId}/book/{bookId}/")
    public Panier putInPanier(@PathVariable(value = "panierId") Long panierId,@PathVariable(value = "bookId") Long bookId
                                  ) {
        Panier panier = panierRepository.findById(panierId).get();
        bookRepository.findById(bookId).get().setPanier(panier);
        panier.getBooks().add(bookRepository.findById(bookId).get());
        panierRepository.save(panier);
        return panier;
    }

}
