package project.day8_ObjectService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.day8_ObjectService.entity.Order;

@Repository
public interface ObjectRepository extends JpaRepository<Order, Integer> {

    List<Order> findByCustomerId(int customerId);

}