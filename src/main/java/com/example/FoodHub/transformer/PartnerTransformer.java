package com.example.FoodHub.transformer;

import com.example.FoodHub.dto.request.DeliveryPartnerRequest;
import com.example.FoodHub.model.DeliveryPartner;

import java.util.ArrayList;

public class PartnerTransformer {

    public static DeliveryPartner PartnerRequestToDeliveryPartner(
            DeliveryPartnerRequest deliveryPartnerRequest){

        return DeliveryPartner.builder()
                .name(deliveryPartnerRequest.getName())
                .mobileNo(deliveryPartnerRequest.getMobileNo())
                .gender(deliveryPartnerRequest.getGender())
                .orders(new ArrayList<>())
                .build();
    }
}
