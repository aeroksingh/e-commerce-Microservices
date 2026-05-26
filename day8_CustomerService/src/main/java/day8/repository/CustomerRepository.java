package day8.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import day8.entity.Customer;

public interface CustomerRepository
        extends JpaRepository<Customer, Integer> {

}