package com.myProject.crm_project.services;

import com.myProject.crm_project.entities.Customer;

import java.util.List;
public interface CustomerService {
    Customer add(Customer customer);

    List<Customer> getAll();

    Customer update(Customer customer);

    void delete(int id);
}
