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

}
