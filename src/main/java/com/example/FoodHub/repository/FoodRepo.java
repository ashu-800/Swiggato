package com.example.FoodHub.repository;

import com.example.FoodHub.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepo extends JpaRepository<FoodItem,Integer> {
}
