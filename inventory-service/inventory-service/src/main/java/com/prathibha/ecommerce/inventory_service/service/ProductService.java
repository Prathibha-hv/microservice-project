package com.prathibha.ecommerce.inventory_service.service;


import com.prathibha.ecommerce.inventory_service.dto.ProductDto;
import com.prathibha.ecommerce.inventory_service.entity.ProductEntity;
import com.prathibha.ecommerce.inventory_service.exception.ResourceNotFoundException;
import com.prathibha.ecommerce.inventory_service.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class ProductService {
   private final ProductRepository productRepository;
   private final ModelMapper mapper;
   private static final Logger log = LoggerFactory.getLogger(ProductService.class);





    public ProductService(ProductRepository productRepository, ModelMapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
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
}
