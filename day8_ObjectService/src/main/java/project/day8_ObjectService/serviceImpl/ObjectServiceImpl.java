package project.day8_ObjectService.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import project.day8_ObjectService.dto.ObjectServiceDTO;
import project.day8_ObjectService.entity.Order;
import project.day8_ObjectService.repository.ObjectRepository;
import project.day8_ObjectService.service.ObjectService;
import project.day8_ObjectService.vo.CustomerVO;
import project.day8_ObjectService.vo.OrderVO;
import project.day8_ObjectService.vo.ProductVO;

@Service
public class ObjectServiceImpl implements ObjectService {

    @Autowired
    private ObjectRepository repo;

    @Autowired
    private RestTemplate rest;

    @Value("${customer-service.url}")
    private String customerServiceUrl;

    @Value("${product-service.url}")
    private String productServiceUrl;

    @Override
    public OrderVO saveOrder(Order order) {

        order.setOrdDate(LocalDate.now());

        CustomerVO cust =
                rest.getForObject(
                        customerServiceUrl + "/" + order.getCustId(),
                        CustomerVO.class
                );

        ProductVO item =
                rest.getForObject(
                        productServiceUrl + "/" + order.getCode(),
                        ProductVO.class
                );

        order.setAmount(item.getProductPrice());

        Order savedOrder = repo.save(order);

        OrderVO vo = new OrderVO();

        vo.setOrdNo(savedOrder.getOrdNo());
        vo.setOrdDate(savedOrder.getOrdDate());
        vo.setAmount(savedOrder.getAmount());

        vo.setCustomer(cust);
        vo.setItem(item);

        return vo;
    }

    @Override
    public List<Order> getAllOrders() {
        return repo.findAll();
    }

    @Override
    public ObjectServiceDTO getOrderDetails(int customerId, int productId) {

        CustomerVO customer =
                rest.getForObject(
                        customerServiceUrl + "/" + customerId,
                        CustomerVO.class
                );

        ProductVO product =
                rest.getForObject(
                        productServiceUrl + "/" + productId,
                        ProductVO.class
                );

        ObjectServiceDTO dto = new ObjectServiceDTO();

        dto.setCustomer(customer);
        dto.setProduct(product);

        return dto;
    }

    @Override
    public OrderVO findByNo(int no) {

        Order order = repo.findById(no).get();

        CustomerVO cust =
                rest.getForObject(
                        customerServiceUrl + "/" + order.getCustId(),
                        CustomerVO.class
                );

        ProductVO item =
                rest.getForObject(
                        productServiceUrl + "/" + order.getCode(),
                        ProductVO.class
                );

        OrderVO vo = new OrderVO();

        vo.setOrdNo(order.getOrdNo());
        vo.setOrdDate(order.getOrdDate());
        vo.setAmount(order.getAmount());

        vo.setCustomer(cust);
        vo.setItem(item);

        return vo;
    }

    @Override
    public List<OrderVO> findByCustomer(int cid) {

//        List<Order> orders = repo.findByCustomer(cid);
    	List<Order> orders = repo.findByCustomerId(cid);
        List<OrderVO> list = new ArrayList<>();

        for (Order order : orders) {

            CustomerVO cust =
                    rest.getForObject(
                            customerServiceUrl + "/" + order.getCustId(),
                            CustomerVO.class
                    );

            ProductVO item =
                    rest.getForObject(
                            productServiceUrl + "/" + order.getCode(),
                            ProductVO.class
                    );

            OrderVO vo = new OrderVO();

            vo.setOrdNo(order.getOrdNo());
            vo.setOrdDate(order.getOrdDate());
            vo.setAmount(order.getAmount());

            vo.setCustomer(cust);
            vo.setItem(item);

            list.add(vo);
        }

        return list;
    }
}