package com.myProject.crm_project.services;

import com.myProject.crm_project.entities.Basket;

import java.util.List;

public interface BasketService {

    Basket addItem(Basket basket);

    List<Basket> getAllItemsFromBasket();

    Basket updateBasket(Basket basket);

    void deleteItemFromBasket(int id);
}
