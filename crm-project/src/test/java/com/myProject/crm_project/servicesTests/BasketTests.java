package com.myProject.crm_project.servicesTests;

import com.myProject.crm_project.entities.Basket;
import com.myProject.crm_project.repositories.BasketRepository;
import com.myProject.crm_project.rules.BasketBusinessRules;
import com.myProject.crm_project.services.BasketServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class BasketServiceImplTest {

    @InjectMocks
    private BasketServiceImpl basketService;

    @Mock
    private BasketRepository basketRepository;

    @Mock
    private BasketBusinessRules basketBusinessRules;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddItem_WhenItemAlreadyExists() {
        // Arrange
        Basket existingBasket = new Basket();
        existingBasket.setItemName("Apple");
        existingBasket.setQuantity(2);

        when(basketBusinessRules.addOrUpdateItemInBasket(existingBasket)).thenReturn(existingBasket);

        // Act
        Basket result = basketService.addItem(existingBasket);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.getQuantity()); // Quantity is updated in business rules
        verify(basketBusinessRules, times(1)).addOrUpdateItemInBasket(existingBasket);
    }

    @Test
    void testAddItem_WhenItemDoesNotExist() {
        // Arrange
        Basket newBasket = new Basket();
        newBasket.setItemName("Banana");
        newBasket.setQuantity(1);

        when(basketBusinessRules.addOrUpdateItemInBasket(newBasket)).thenReturn(newBasket);

        // Act
        Basket result = basketService.addItem(newBasket);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.getQuantity()); // Quantity should be set to 1
        verify(basketBusinessRules, times(1)).addOrUpdateItemInBasket(newBasket);
    }

    @Test
    void testDeleteItemFromBasket() {
        // Arrange
        int basketId = 1;
        doNothing().when(basketRepository).deleteById(basketId);

        // Act
        basketService.deleteItemFromBasket(basketId);

        // Assert
        verify(basketRepository, times(1)).deleteById(basketId);
    }

    @Test
    void testGetAllItemsFromBasket() {
        // Arrange
        Basket basket1 = new Basket();
        basket1.setId(1);
        basket1.setItemName("Apple");
        basket1.setQuantity(2);

        Basket basket2 = new Basket();
        basket2.setId(2);
        basket2.setItemName("Banana");
        basket2.setQuantity(3);

        List<Basket> expectedBaskets = List.of(basket1, basket2);

        when(basketRepository.findAll()).thenReturn(expectedBaskets);

        // Act
        List<Basket> result = basketService.getAllItemsFromBasket();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Apple", result.get(0).getItemName());
        assertEquals("Banana", result.get(1).getItemName());
        verify(basketRepository, times(1)).findAll();
    }



}