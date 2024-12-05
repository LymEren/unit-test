package com.myProject.crm_project.services;

import com.myProject.crm_project.entities.Product;
import com.myProject.crm_project.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Bu class bu interfacein icinin dolu oldugu versiyondur
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;


    @Override
    public Product add(Product product) {

        // is kurallari buraya yazilir
        // Bir kisi %20 indirimden yararlanacaksa 1 yildir abone olmali
        // Eger bu kurallardan gecerse db ye yazilacak

        // Git bu productin ismini oku
        Optional<Product> productCheck = productRepository.findByNameIgnoreCase(product.getName());

        if (productCheck.isPresent()) {
            throw new RuntimeException("Bu ürün zaten kayıtlı.");
        }

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
