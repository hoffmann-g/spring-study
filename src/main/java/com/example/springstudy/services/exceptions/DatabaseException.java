package com.example.springstudy.services.exceptions;

public class DatabaseException extends RuntimeException {
    
    public DatabaseException(Object obj){
        super("Integrity violated. ID " + obj);
    }
}
