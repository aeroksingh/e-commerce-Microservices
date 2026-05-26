package day8.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import day8.entity.Customer;
import day8.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    CustomerService service;

    // INSERT
    @PostMapping("/add")
    public Customer addCustomer(
            @RequestBody Customer customer) {

        return service.addCustomer(customer);
    }

    // FETCH ALL
    @GetMapping("/all")
    public List<Customer> getAllCustomers() {

        return service.getAllCustomers();
    }

    // FETCH BY ID
    @GetMapping("/{id}")
    public Customer getCustomerById(
            @PathVariable int id) {

        return service.getCustomerById(id);
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public Customer updateCustomer(
            @PathVariable int id,
            @RequestBody Customer customer) {

        return service.updateCustomer(id, customer);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(
            @PathVariable int id) {

        return service.deleteCustomer(id);
    }
} 