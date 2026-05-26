package project.day8_ProductService.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.day8_ProductService.entity.Product;
import project.day8_ProductService.globalexception.ResourceNotFoundException;
import project.day8_ProductService.repository.ProductRepository;
import project.day8_ProductService.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int productId) {

        return productRepository.findById(productId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Product Not Found With ID : " + productId
                        ));
    }

    @Override
    public String deleteProduct(int productId) {

        productRepository.deleteById(productId);

        return "Product Deleted Successfully";
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }
}