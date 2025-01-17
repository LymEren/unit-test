package com.myProject.crm_project.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "basket")
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "itemName", nullable = false)
    @Size(max = 100)
    private String itemName;

    @Column(name = "quantity")
    private int quantity;

}
