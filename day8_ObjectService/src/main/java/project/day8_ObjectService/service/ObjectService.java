package project.day8_ObjectService.service;

import java.util.List;

import project.day8_ObjectService.dto.ObjectServiceDTO;
import project.day8_ObjectService.entity.Order;
import project.day8_ObjectService.vo.OrderVO;

public interface ObjectService {

    // Save Order
    OrderVO saveOrder(Order order);

    // Get All Orders
    List<Order> getAllOrders();

    // Get Complete Order Details
    ObjectServiceDTO getOrderDetails(int customerId, int productId);

	OrderVO findByNo(int no);

	List<OrderVO> findByCustomer(int cid);

}