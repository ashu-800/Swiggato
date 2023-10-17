package com.example.FoodHub.exception;

public class MenuItemNotFoundException extends RuntimeException{
    public MenuItemNotFoundException(String message){
        super(message);
    }
}
