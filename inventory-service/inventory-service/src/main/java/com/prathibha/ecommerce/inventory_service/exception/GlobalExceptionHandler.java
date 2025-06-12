package com.prathibha.ecommerce.inventory_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException{

    @ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<String> handleResourceNotFounfException(ResourceNotFoundException exception)
{
return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
}
}
