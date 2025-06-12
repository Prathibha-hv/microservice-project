package com.prathibha.ecommerce.order_service.controller;

import com.prathibha.ecommerce.order_service.dto.OrderRequestDto;
import com.prathibha.ecommerce.order_service.repository.OrderRepository;
import com.prathibha.ecommerce.order_service.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderService orderService;
    private ModelMapper modelMapper;


    public OrderController(OrderService orderService, ModelMapper modelMapper) {
        this.orderService = orderService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/fetchAll")
    public String fetchOrders()
    {
        return "Hello from order service fetch method";
    }
    @GetMapping
    public ResponseEntity<List<OrderRequestDto>> getAllOrers()
    {
   List<OrderRequestDto> allOrders =orderService.getAllOrders();
   return ResponseEntity.ok(allOrders);
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrderRequestDto> getOrderById(@PathVariable Long id)
    {
        OrderRequestDto order=orderService.getOrderById(id);
        return ResponseEntity.ok(order);
    }

}
