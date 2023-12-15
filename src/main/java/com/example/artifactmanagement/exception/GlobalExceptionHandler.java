package com.example.artifactmanagement.exception;

import org.springframework.beans.factory.xml.ResourceEntityResolver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity handleResourceNotFoundException(ResourceNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleArgumentNotValidException(MethodArgumentNotValidException exception){
        List<ObjectError> objectErrors = exception.getBindingResult().getAllErrors();
        Map<String,String> map = new HashMap<>(objectErrors.size());
        objectErrors.forEach(objectError ->{
            String key ;
            if (objectError instanceof FieldError) {
                FieldError fieldError = (FieldError) objectError;
                key = fieldError.getField();
            } else {
                key = objectError.getObjectName();
            }
            String errorMessage = objectError.getDefaultMessage();
            map.put(key, errorMessage);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
    }
}
