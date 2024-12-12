package com.myProject.crm_project.services;

import com.myProject.crm_project.entities.Basket;
import com.myProject.crm_project.repositories.BasketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BasketServiceImpl implements BasketService{

    private BasketRepository basketRepository;

    @Override
    public Basket addItem(Basket basket) {

        basketRepository.findByItemNameIgnoreCase(basket.getItemName());
        return basketRepository.save(basket);
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

