package com.myProject.crm_project.services;

import com.myProject.crm_project.entities.Product;
import com.myProject.crm_project.repositories.ProductRepository;
import com.myProject.crm_project.rules.ProductBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ProductBusinessRules productBusinessRules;


    @Override
    public Product add(Product product) {


        productBusinessRules.productNameCannotBeDublicated(product.getName());

        Product createdProduct = productRepository.save(product);
        return createdProduct;

    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }

}
