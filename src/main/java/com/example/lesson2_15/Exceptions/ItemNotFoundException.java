package com.example.lesson2_15.Exceptions;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException (String message) {
        super(message);
    }
}
