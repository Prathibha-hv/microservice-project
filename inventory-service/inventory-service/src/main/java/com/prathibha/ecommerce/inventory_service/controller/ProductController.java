package com.prathibha.ecommerce.inventory_service.controller;

import com.prathibha.ecommerce.inventory_service.dto.ProductDto;
import com.prathibha.ecommerce.inventory_service.service.ProductService;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
@RequestMapping(path = "/app")
public class ProductController {

    private final ProductService productService ;

    public ProductController(ProductService service, DiscoveryClient discoveryClient, RestClient restClient) {
        this.productService = service;
        this.discoveryClient = discoveryClient;
        this.restClient = restClient;
    }

    private DiscoveryClient discoveryClient;
    private final RestClient restClient;

    @GetMapping("/fetchOrders")
    public String fetchOrdersfromOrderService()
    {
        ServiceInstance orders =discoveryClient.getInstances("order-service").get(0);
       return restClient.get().uri(orders.getUri()+"/orders/fetchAll").retrieve().body(String.class);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllInventories()
    {
        List<ProductDto> inventories= productService.getAllInventory();
        return ResponseEntity.ok(inventories);
    }

    @GetMapping("/test")
    public String test() {
        return "Hello from Inventory Service!";
    }

    @GetMapping(path = "/{id}",produces = "application/json")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id)
    {
        ProductDto dto=productService.getProductById(id);
        return ResponseEntity.ok(dto);
    }

}
