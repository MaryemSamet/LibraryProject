package com.libraryproject.library.Repository;

import com.libraryproject.library.Model.Panier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PanierRepository extends JpaRepository<Panier,Long> {
 }
