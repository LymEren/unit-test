package com.myProject.crm_project.repositories;

import com.myProject.crm_project.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    // Springte bir repository olusturdugumuz zaman sen bir jpa (persistance api) kullanacaksin
    // ve bu jpa yi kullanarak product tablosuna erisim saglayacak primary key id olacak sekilde
    // insert update olusturur

    Optional<Product> findByNameIgnoreCase(String name); // Name'i buyuk kucuk harf duyarli olarak arar db'ye gider sorgu atar
}


