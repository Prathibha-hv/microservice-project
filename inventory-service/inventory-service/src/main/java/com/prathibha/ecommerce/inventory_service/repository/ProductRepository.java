package com.prathibha.ecommerce.inventory_service.repository;

import com.prathibha.ecommerce.inventory_service.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
