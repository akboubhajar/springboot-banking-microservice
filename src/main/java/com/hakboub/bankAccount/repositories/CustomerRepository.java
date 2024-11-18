package com.hakboub.bankAccount.repositories;

import com.hakboub.bankAccount.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer,Long> {
 }
