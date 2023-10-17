package com.example.FoodHub.service;

import com.example.FoodHub.dto.request.MenuRequest;
import com.example.FoodHub.dto.request.RestaurantRequest;
import com.example.FoodHub.dto.response.RestaurantResponse;
import com.example.FoodHub.exception.RestaurantNotFoundException;
import com.example.FoodHub.model.MenuItem;
import com.example.FoodHub.model.Restaurant;
import com.example.FoodHub.repository.RestaurantRespository;
import com.example.FoodHub.transformer.MenuItemTransformer;
import com.example.FoodHub.transformer.RestaurantTransformer;
import com.example.FoodHub.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    final RestaurantRespository restaurantRespository;
    final ValidationUtils validationUtils;

    @Autowired
    public RestaurantService(RestaurantRespository restaurantRespository,
                             ValidationUtils validationUtils) {
        this.restaurantRespository = restaurantRespository;
        this.validationUtils = validationUtils;
    }

    public RestaurantResponse addRestaurant(RestaurantRequest restaurantRequest) {

        // dto -> model
        Restaurant restaurant = RestaurantTransformer.RestaurantRequestToRestaurant(restaurantRequest);
        //persist/save the model in db
        Restaurant savedRestaurant = restaurantRespository.save(restaurant);
        // prepare response dto from model
        return RestaurantTransformer.RestaurantToRestaurantResponse(savedRestaurant);
    }

    public String changeOpenedStatus(int id) {

        //check whether id is valid or not
        if(!validationUtils.validateRestaurantId(id)){
            throw new RestaurantNotFoundException("Restaurant doesn't exist!!");
        }

        Restaurant restaurant = restaurantRespository.findById(id).get();
        restaurant.setOpened(!restaurant.isOpened());
        restaurantRespository.save(restaurant);

        if(restaurant.isOpened()){
            return "Restaurant is opened now!!!";
        }

        return "Restaurant is closed";
    }

    public RestaurantResponse addMenuItemtToRestaurant(MenuRequest menuRequest) {

        // check reataurant is valid or not
        if(!validationUtils.validateRestaurantId(menuRequest.getRestaurantId())){
            throw new RestaurantNotFoundException("Restaurant doesn't exist!!");
        }

        Restaurant restaurant = restaurantRespository.findById(menuRequest.getRestaurantId()).get();
        // make food entity
        MenuItem menuItem = MenuItemTransformer.MenuRequestToMenuItem(menuRequest);
        menuItem.setRestaurant(restaurant);

        restaurant.getAvailableMenuItems().add(menuItem);

        // save rest and food
        Restaurant savedRestaurant = restaurantRespository.save(restaurant);

        // prepare response
        return RestaurantTransformer.RestaurantToRestaurantResponse(savedRestaurant);

    }
}
