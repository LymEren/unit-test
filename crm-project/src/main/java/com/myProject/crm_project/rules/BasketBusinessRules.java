package com.myProject.crm_project.rules;

import com.myProject.crm_project.entities.Basket;
import com.myProject.crm_project.repositories.BasketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BasketBusinessRules {
    private BasketRepository basketRepository;

    public boolean isProductAlreadyInBasket(String productName) {
        Optional<Basket> productCheck = basketRepository.findByItemNameIgnoreCase(productName);
        return productCheck.isPresent();
    }

    public Basket addOrUpdateItemInBasket(Basket basket) {
        boolean isExist = isProductAlreadyInBasket(basket.getItemName());

        if (isExist) {
            Optional<Basket> existingBasket = basketRepository.findByItemNameIgnoreCase(basket.getItemName());
            if (existingBasket.isPresent()) {
                Basket existingProduct = existingBasket.get();
                existingProduct.setQuantity(existingProduct.getQuantity() + 1);
                return basketRepository.save(existingProduct);
            }
        } else {
            basket.setQuantity(1);
            return basketRepository.save(basket);
        }
        System.out.println("No changes made to the basket.");
        return basket;
    }
}