package com.myProject.crm_project.services;

import com.myProject.crm_project.entities.Customer;
import com.myProject.crm_project.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Override
    public Customer add(Customer customer) {

        Customer createdCustomer = customerRepository.save(customer);
        return createdCustomer;

    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer update(Customer customer) {

        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }

        Optional<Customer> ageCheck = customerRepository.findByAge(customer.getAge());

        if (ageCheck.isPresent()) {
            throw new RuntimeException("Ne güzel şeysin sen hep yaşın " + customer.getAge() + ".\n Lütfen yeni bir yaş giriniz.");
        }

        return customerRepository.save(customer);
    }

    @Override
    public void delete(int id) {
        customerRepository.deleteById(id);
    }
}
