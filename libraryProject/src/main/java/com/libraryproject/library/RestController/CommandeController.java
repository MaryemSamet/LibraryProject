package com.libraryproject.library.RestController;

import com.libraryproject.library.Model.Book;
import com.libraryproject.library.Model.Commande;
import com.libraryproject.library.Model.Customer;
import com.libraryproject.library.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController

public class CommandeController {
    @Autowired
    private CommandeRepository commandeRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private BookRepository bookRepository;


    @GetMapping("/customer/{customerId}/commandes")
    public List<Commande> getAllCommandesByCustomerId(@PathVariable   (value = "customerId") Long customerId) {
        return commandeRepository.findByCustomerId(customerId);
    }

    @PostMapping("/customer/{customerId}/panier/{panierId}/books")
    public Commande createCommande(@PathVariable(value = "customerId") Long customerId,@PathVariable(value = "panierId") Long panierId,
                                  @Valid @RequestBody Commande commande) {
        commande.setCustomer(customerRepository.findById(customerId).get());
        for (Book book:bookRepository.findByPanierId(panierId)
             ) {
            commande.getBooks().add(book);
            book.setAvailability("0");
            book.setCommande(commande);
        }

        commandeRepository.save(commande);
        return commande;
    }
   /* @PutMapping("/customer/{customerId}/book/{bookId}/commande/{commandeId}/books")
    public Commande putInCommande(@PathVariable(value = "commandeId") Long commandeId,@PathVariable(value = "bookId") Long bookId,
                           ) {
        Commande commande = commandeRepository.findById(commandeId).get();
         commande.getBooks().add(bookRepository.findById(bookId).get());
        commandeRepository.save(commande);
        return commande;
    }
    */
    @RequestMapping(value = "/commande/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteCommande(@PathVariable(name = "id", value = "id") Long id) {
        commandeRepository.deleteById(id);
        return new ResponseEntity("commande deleted ", HttpStatus.OK);
    }


}
