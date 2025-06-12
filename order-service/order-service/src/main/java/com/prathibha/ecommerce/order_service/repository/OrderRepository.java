package com.prathibha.ecommerce.order_service.repository;

import com.prathibha.ecommerce.order_service.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
