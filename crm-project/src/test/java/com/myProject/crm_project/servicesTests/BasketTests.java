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

}