package com.prathibha.ecommerce.order_service.service;

import com.prathibha.ecommerce.order_service.dto.OrderRequestDto;
import com.prathibha.ecommerce.order_service.entity.OrderEntity;
import com.prathibha.ecommerce.order_service.entity.OrderItem;
import com.prathibha.ecommerce.order_service.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private  final ModelMapper modelMapper;

    public OrderService(ModelMapper modelMapper, OrderRepository orderRepository) {
        this.modelMapper = modelMapper;
        this.orderRepository=orderRepository;
    }

    public List<OrderRequestDto> getAllOrders()
    {
//        log.info("fetching all orders");
        List<OrderEntity> orders=orderRepository.findAll();
        return orders.stream().map(order -> modelMapper.map(order, OrderRequestDto.class)).toList();
    }

    public OrderRequestDto getOrderById(Long id)
    {
        OrderEntity order=orderRepository.findById(id).orElseThrow(()-> new RuntimeException("Order not found"));
        return modelMapper.map(order, OrderRequestDto.class);
    }
}
