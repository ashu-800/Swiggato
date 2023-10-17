package com.example.FoodHub.transformer;

import com.example.FoodHub.dto.response.FoodResponse;
import com.example.FoodHub.model.FoodItem;

public class FoodTransformer {

    public static FoodResponse FoodToFoodResponse(FoodItem food){
        return FoodResponse.builder()
                .dishName(food.getMenuItem().getDishName())
                .price(food.getMenuItem().getPrice())
                .category(food.getMenuItem().getCategory())
                .veg(food.getMenuItem().isVeg())
                .quantityAdded(food.getRequiredQuantity())
                .build();
    }
}
