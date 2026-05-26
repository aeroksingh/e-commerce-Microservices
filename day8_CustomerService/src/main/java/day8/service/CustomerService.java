package day8.service;

import java.util.List;

import day8.entity.Customer;

public interface CustomerService {

    Customer addCustomer(Customer customer);

    List<Customer> getAllCustomers();

    Customer getCustomerById(int id);

    Customer updateCustomer(int id, Customer customer);

    String deleteCustomer(int id);
}