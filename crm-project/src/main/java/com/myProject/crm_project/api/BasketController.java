package com.myProject.crm_project.api;

import com.myProject.crm_project.entities.Basket;
import com.myProject.crm_project.services.BasketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/basket")
@AllArgsConstructor
public class BasketController {

    private BasketService basketService;

    @PostMapping
    public Basket addItem(@RequestBody Basket basket){
        return basketService.addItem(basket);
    }

    @GetMapping
    public List<Basket> getAll(){
        return basketService.getAllItemsFromBasket();
    }

    @PutMapping
    public Basket updateBasket(@RequestBody Basket basket){
        return basketService.updateBasket(basket);
    }

    public void deleteItemFromBasket(@RequestParam(value = "id") int id){
        basketService.deleteItemFromBasket(id);
    }

}
