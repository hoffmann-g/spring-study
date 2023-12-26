package com.example.springstudy.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(Object obj){
        super("Resource not found. Id " + obj);
    }
}
