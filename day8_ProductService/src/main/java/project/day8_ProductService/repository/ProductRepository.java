package project.day8_ProductService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.day8_ProductService.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}