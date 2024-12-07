package com.myProject.crm_project.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cust")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // otomatik artan
    @Column(name = "id")
    private int id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "age")
    private int age;
}
