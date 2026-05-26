package project.day8_ObjectService.dto;

import project.day8_ObjectService.vo.CustomerVO;
import project.day8_ObjectService.vo.ProductVO;

public class ObjectServiceDTO {

    private CustomerVO customer;
    private ProductVO product;

    public ObjectServiceDTO() {
    }

    public ObjectServiceDTO(CustomerVO customer, ProductVO product) {
        this.customer = customer;
        this.product = product;
    }

    public CustomerVO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerVO customer) {
        this.customer = customer;
    }

    public ProductVO getProduct() {
        return product;
    }

    public void setProduct(ProductVO product) {
        this.product = product;
    }
}