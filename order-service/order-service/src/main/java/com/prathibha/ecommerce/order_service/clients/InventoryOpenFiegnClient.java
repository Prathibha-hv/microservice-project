package com.prathibha.ecommerce.order_service.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name="inventory-service",path = "/app")
public interface InventoryOpenFiegnClient {

    @PutMapping("/app/reduce-stocks")
    Double reduceStocks();



}
