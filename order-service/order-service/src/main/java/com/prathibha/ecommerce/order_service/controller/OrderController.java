package com.prathibha.ecommerce.order_service.controller;

import com.prathibha.ecommerce.order_service.clients.InventoryOpenFiegnClient;
import com.prathibha.ecommerce.order_service.dto.OrderRequestDto;
import com.prathibha.ecommerce.order_service.repository.OrderRepository;
import com.prathibha.ecommerce.order_service.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderService orderService;
    private ModelMapper modelMapper;
    private InventoryOpenFiegnClient inventoryOpenFiegnClient;


    public OrderController(OrderService orderService, ModelMapper modelMapper) {
        this.orderService = orderService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/create-order")
    public ResponseEntity<OrderRequestDto> createOrder(@RequestBody OrderRequestDto orderRequestDto)
    {
Double totalPrice=inventoryOpenFiegnClient.reduceStocks(orderRequestDto);
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
