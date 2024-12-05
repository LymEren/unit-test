package com.myProject.crm_project.services;

import com.myProject.crm_project.entities.Product;

import java.util.List;

// Bu katmanda is kurallari yazilacak
public interface ProductService {

    // Yeni bir ürünü ekler ve eklenen ürünü döner.
    Product add(Product product);

    // Tüm ürünlerin listesini döner.
    List<Product> getAll();

    //  Mevcut bir ürünü günceller ve güncellenen ürünü döner.
    Product update(Product product);

    //  Bir ürünü kimlik (ID) numarasıyla siler.
    void delete(int id);
}
