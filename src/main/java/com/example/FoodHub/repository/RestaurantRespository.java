package com.example.FoodHub.repository;

import com.example.FoodHub.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRespository extends JpaRepository<Restaurant,Integer> {
}
