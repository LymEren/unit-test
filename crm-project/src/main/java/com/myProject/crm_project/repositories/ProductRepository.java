package com.myProject.crm_project.repositories;

import com.myProject.crm_project.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer>  {

    Optional<Product> findByNameIgnoreCase(String name);
}


