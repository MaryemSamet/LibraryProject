package com.libraryproject.library.Repository;

import com.libraryproject.library.Model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepository extends JpaRepository<Promotion,Long> {
}
