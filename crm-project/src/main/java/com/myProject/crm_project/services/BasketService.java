package com.myProject.crm_project.services;

import com.myProject.crm_project.entities.Customer;

import java.util.List;

public interface BasketService {

    Customer addCustomer(Customer customer);

    List<Customer> getAllCustomers();

    Customer updateCustomer(Customer customer);

    void deleteCustomer(int id);
}
