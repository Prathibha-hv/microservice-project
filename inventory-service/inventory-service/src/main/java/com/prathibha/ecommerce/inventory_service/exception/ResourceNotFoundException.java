package com.prathibha.ecommerce.inventory_service.exception;



 public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message)
    {
        super(message);
    }
}
