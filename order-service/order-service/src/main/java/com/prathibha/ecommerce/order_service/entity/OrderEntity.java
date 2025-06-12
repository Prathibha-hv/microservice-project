package com.prathibha.ecommerce.order_service.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class OrderEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private  Double price;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems;

//    private Long pruductId;
//    private  Long quantity;





    public OrderEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}

