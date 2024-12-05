package com.myProject.crm_project.api;

import com.myProject.crm_project.entities.Product;
import com.myProject.crm_project.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Sen bir rest controllersin
@RestController
@RequestMapping("/api/products") // Domainin sonuna bu gelirse bu controller calisacak
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    // Burada request body sinden cekmesini sagladik
    @PostMapping
    public Product add(@RequestBody Product product) {
        return productService.add(product);
    }

    // Buradaki annotasyonlari spring-web veya spring-webmvc den cekiyor
    @GetMapping
    public List<Product> getAll(){
        return productService.getAll();
    }

    @PutMapping
    public Product update(@RequestBody Product product) {
        return productService.update(product);
    }

    @DeleteMapping
    public void delete(@RequestParam(value="id") int id){
        productService.delete(id);
    }


}
