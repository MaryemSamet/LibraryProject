package com.libraryproject.library.Repository;

import com.libraryproject.library.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
