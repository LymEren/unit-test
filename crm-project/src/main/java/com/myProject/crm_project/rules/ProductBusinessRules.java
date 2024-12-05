package com.myProject.crm_project.rules;


import com.myProject.crm_project.entities.Product;
import com.myProject.crm_project.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductBusinessRules {
    private ProductRepository productRepository;

    public void productNameCannotBeDublicated(String productName) {
        Optional<Product> productCheck = productRepository.findByNameIgnoreCase(productName);

        if (productCheck.isPresent()) {
            throw new RuntimeException("Bu ürün zaten kayıtlı.");
        }
        }
    }
