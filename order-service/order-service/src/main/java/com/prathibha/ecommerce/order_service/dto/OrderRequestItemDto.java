package com.prathibha.ecommerce.order_service.dto;

public class OrderRequestItemDto {
//    private Long id;
    private Long productid;
    private Integer quantity;

    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
