package project.day8_ProductService.service;

import java.util.List;

import project.day8_ProductService.entity.Product;

public interface ProductService {

    Product saveProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(int productId);

    String deleteProduct(int productId);

    Product updateProduct(Product product);
}