package com.example.FoodHub.service;

import com.example.FoodHub.dto.request.DeliveryPartnerRequest;
import com.example.FoodHub.model.DeliveryPartner;
import com.example.FoodHub.repository.DeliveryPartnerRepo;
import com.example.FoodHub.transformer.PartnerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryPartnerService {

    final DeliveryPartnerRepo deliveryPartnerRepo;

    @Autowired
    public DeliveryPartnerService(DeliveryPartnerRepo deliveryPartnerRepo) {
        this.deliveryPartnerRepo = deliveryPartnerRepo;
    }

    public String addPartner(DeliveryPartnerRequest deliveryPartnerRequest) {

        //dto -> entity
        DeliveryPartner deliveryPartner = PartnerTransformer.PartnerRequestToDeliveryPartner(deliveryPartnerRequest);

        // save
        DeliveryPartner savedPartner = deliveryPartnerRepo.save(deliveryPartner);

        return "You have been successfully regsitered!!!";

    }
}
