package com.myProject.crm_project.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data // lombok get set hepsine otomatik koyuyor
@Entity
@Table(name = "products") // Sen bir tablosun ve buna karsilik geliyorsun
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // otomatik artan
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "unitPrice")
    private double unitPrice;

}