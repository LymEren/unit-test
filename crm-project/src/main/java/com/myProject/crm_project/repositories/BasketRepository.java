package com.myProject.crm_project.repositories;

import com.myProject.crm_project.entities.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BasketRepository extends JpaRepository<Basket, Integer> {

    Optional<Basket> findByItemNameIgnoreCase (String itemName);
}
