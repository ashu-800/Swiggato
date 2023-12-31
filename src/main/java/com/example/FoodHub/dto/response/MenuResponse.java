package com.example.FoodHub.dto.response;

import com.example.FoodHub.Enum.FoodCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuResponse {

    String dishName;

    double price;

    FoodCategory category;

    boolean veg;
}
