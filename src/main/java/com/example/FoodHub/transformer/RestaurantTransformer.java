package com.example.FoodHub.transformer;

import com.example.FoodHub.dto.request.RestaurantRequest;
import com.example.FoodHub.dto.response.MenuResponse;
import com.example.FoodHub.dto.response.RestaurantResponse;
import com.example.FoodHub.model.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RestaurantTransformer {

    public static Restaurant RestaurantRequestToRestaurant(RestaurantRequest restaurantRequest){
         return Restaurant.builder()
                 .name(restaurantRequest.getName())
                 .contactNumber(restaurantRequest.getContactNumber())
                 .location(restaurantRequest.getLocation())
                 .restrauntCategory(restaurantRequest.getRestrauntCategory())
                 .opened(true)
                 .availableMenuItems(new ArrayList<>())
                 .orders(new ArrayList<>())
                 .build();
    }

    public static RestaurantResponse RestaurantToRestaurantResponse(Restaurant restaurant){

        List<MenuResponse> menu = restaurant.getAvailableMenuItems()
                .stream()
                .map(foodItem -> MenuItemTransformer.MenuItemToMenuResponse(foodItem))
                .collect(Collectors.toList());

        return RestaurantResponse.builder()
                .name(restaurant.getName())
                .contactNumber(restaurant.getContactNumber())
                .location(restaurant.getLocation())
                .opened(restaurant.isOpened())
                .menu(menu)
                .build();
    }
}
