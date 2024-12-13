package com.myProject.crm_project.services;

import com.myProject.crm_project.entities.Basket;
import com.myProject.crm_project.repositories.BasketRepository;
import com.myProject.crm_project.rules.BasketBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BasketServiceImpl implements BasketService {

    private BasketRepository basketRepository;
    private BasketBusinessRules basketBusinessRules;

    @Override
    public Basket addItem(Basket basket) {

        boolean isExist = basketBusinessRules.productCannotBeAddedTwice(basket.getItemName());

        if (isExist) {
            Optional<Basket> existingBasket = basketRepository.findByItemNameIgnoreCase(basket.getItemName());
            if (existingBasket.isPresent()) {
                Basket existingProduct = existingBasket.get();
                existingProduct.setQuantity(existingProduct.getQuantity() + 1);
                return basketRepository.save(existingProduct);
            } else {
                basket.setQuantity(1);
                return basketRepository.save(basket);

            }
        }
        return basket;
    }

    @Override
    public List<Basket> getAllItemsFromBasket() {
        return basketRepository.findAll();
    }

    @Override
    public Basket updateBasket(Basket basket) {
        return basketRepository.save(basket);
    }

    @Override
    public void deleteItemFromBasket(int id) {
        basketRepository.deleteById(id);
    }
}

