package project.day8_ProductService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import project.day8_ProductService.entity.Product;
import project.day8_ProductService.service.ProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Insert Product
    @PostMapping("/save")
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    // Get All Products
    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Get Product By ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") int productId) {
        return productService.getProductById(productId);
    }

    // Delete Product
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int productId) {
        return productService.deleteProduct(productId);
    }

    // Update Product
    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }
}