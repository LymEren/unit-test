package com.myProject.crm_project.repositories;

import com.myProject.crm_project.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {


    // Query methods
    Optional<Customer> findByAge(int age);
}



