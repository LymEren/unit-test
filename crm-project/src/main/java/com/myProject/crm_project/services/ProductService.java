package com.myProject.crm_project.services;

import com.myProject.crm_project.entities.Product;

import java.util.List;

public interface ProductService {

    Product add(Product product);

    List<Product> getAll();

    Product update(Product product);

    void delete(int id);
}
