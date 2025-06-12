package com.prathibha.ecommerce.inventory_service;

import com.prathibha.ecommerce.inventory_service.entity.ProductEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {
//	ProductEntity entity= new ProductEntity();

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
//		InventoryServiceApplication in=new InventoryServiceApplication();
//		in.test();

	}
//void test()
//{
//	System.out.println(entity.getTitle());
//}

}
