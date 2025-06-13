package com.prathibha.ecommerce.inventory_service.dto;

import com.prathibha.ecommerce.order_service.dto.OrderRequestItemDto;

import java.util.List;

public class OrderRequestDto {
    private List<OrderRequestItemDto> items;

    public List<OrderRequestItemDto> getItems() {
        return items;
    }

    public void setItems(List<OrderRequestItemDto> items) {
        this.items = items;
    }
}
