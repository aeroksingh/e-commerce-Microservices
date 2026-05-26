package project.day8_ObjectService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import project.day8_ObjectService.entity.Order;
import project.day8_ObjectService.service.ObjectService;
import project.day8_ObjectService.vo.OrderVO;

@RestController
@RequestMapping("/api/v1/orders")
public class Controller {

    @Autowired
    private ObjectService service;

    @PostMapping
    // http://localhost:9003/api/v1/orders
    public ResponseEntity<OrderVO> save(
            @RequestBody Order order) {

        OrderVO resp = service.saveOrder(order);

        return new ResponseEntity<OrderVO>(
                resp,
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{no}")
    // http://localhost:9003/api/v1/orders/1
    public ResponseEntity<OrderVO> findByNo(
            @PathVariable int no) {

        OrderVO resp = service.findByNo(no);

        return new ResponseEntity<OrderVO>(
                resp,
                HttpStatus.FOUND
        );
    }

    @GetMapping("/customer/{cid}")
    // http://localhost:9003/api/v1/orders/customer/1
    public ResponseEntity<List<OrderVO>> findByCustomer(
            @PathVariable int cid) {

        List<OrderVO> resp = service.findByCustomer(cid);

        return new ResponseEntity<List<OrderVO>>(
                resp,
                HttpStatus.FOUND
        );
    }
}