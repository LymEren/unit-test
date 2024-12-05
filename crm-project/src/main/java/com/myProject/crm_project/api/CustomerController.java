package com.myProject.crm_project.api;

import com.myProject.crm_project.entities.Customer;
import com.myProject.crm_project.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer") // Domainin sonuna bu gelirse bu controller calisacak
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;


    @PostMapping
    public Customer add(@RequestBody Customer customer) {
        return customerService.add(customer);
    }

    @GetMapping
    public List<Customer> getAll(){
        return customerService.getAll();
    }

    @PutMapping
    public Customer update(@RequestBody Customer customer) {
        return customerService.update(customer);
    }

    @DeleteMapping
    public void delete(@RequestParam(value="id") int id){
        customerService.delete(id);
    }
}
