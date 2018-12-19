package com.libraryproject.library.Repository;

import com.libraryproject.library.Model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande , Long> {
public List<Commande> findByCustomerId(Long customerId);
}
