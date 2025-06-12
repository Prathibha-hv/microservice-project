package com.prathibha.ecommerce.order_service.entity;

import jakarta.persistence.*;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;

    private Integer quantity;

//    @Enumerated(EnumType.STRING)
//    private OrderStatus orderStatus;

//    private Double price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;



    public OrderItem(Long id) {
        this.id = id;
    }

    public OrderItem() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
