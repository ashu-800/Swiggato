package com.example.FoodHub.controller;

import com.example.FoodHub.dto.request.FoodRequest;
import com.example.FoodHub.dto.response.CartStatusResponse;
import com.example.FoodHub.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

    final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add")
    public ResponseEntity addFoodItemToCart(@RequestBody FoodRequest foodRequest){
        try {
            CartStatusResponse cartStatusResponse = cartService.addFoodItemToCart(foodRequest);
            return new ResponseEntity(cartStatusResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
