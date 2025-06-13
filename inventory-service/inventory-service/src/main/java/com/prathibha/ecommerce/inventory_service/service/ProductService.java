package com.prathibha.ecommerce.inventory_service.service;


import com.prathibha.ecommerce.inventory_service.dto.ProductDto;
import com.prathibha.ecommerce.inventory_service.entity.ProductEntity;
import com.prathibha.ecommerce.inventory_service.exception.ResourceNotFoundException;
import com.prathibha.ecommerce.inventory_service.repository.ProductRepository;
import com.prathibha.ecommerce.order_service.dto.OrderRequestDto;
import com.prathibha.ecommerce.order_service.dto.OrderRequestItemDto;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Service
public class ProductService {
   private final ProductRepository productRepository;
   private final ModelMapper mapper;
   private  final  OrderRequestDto orderRequestDto;
   private static final Logger log = LoggerFactory.getLogger(ProductService.class);





    public ProductService(ProductRepository productRepository, ModelMapper mapper, OrderRequestDto orderRequestDto) {
        this.productRepository = productRepository;
        this.mapper = mapper;
        this.orderRequestDto = orderRequestDto;
    }

    public List<ProductDto> getAllInventory()
    {
        log.info("Fetching all the inventory items");
       List<ProductEntity> productEntities= productRepository.findAll();
      return productEntities.stream()
               .map(product -> mapper.map(product,ProductDto.class))
               .toList();


    }

    public ProductDto getProductById(Long id) {
        log.info("fething the product with id "+id);
        ProductEntity productEntity=productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product not found with id "+id));

    return mapper.map(productEntity,ProductDto.class);
    }

    @Transactional
    public Double reduceStocks(OrderRequestDto orderRequestDto) {
        Double totalPrice=0.0;
        for(OrderRequestItemDto orderRequestItemDto : orderRequestDto.getItems()) {
            Long productid = orderRequestItemDto.getProductid();
            Integer quantity = orderRequestItemDto.getQuantity();

            ProductEntity productEntity = productRepository.findById(productid).orElseThrow(() -> new RuntimeException("Product not found with id : " + productid));

            if (productEntity.getStock() < quantity) {
                throw new RuntimeException("Product cannot be fulfilled for given quantity");

            }

            productEntity.setStock(productEntity.getStock() - quantity);
            productRepository.save(productEntity);
            totalPrice += quantity + productEntity.getPrice();

        }
        return totalPrice;
    }
}
