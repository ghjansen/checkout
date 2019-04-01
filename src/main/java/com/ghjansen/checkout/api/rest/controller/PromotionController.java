package com.ghjansen.checkout.api.rest.controller;

import com.ghjansen.checkout.persistence.model.Promotion;
import com.ghjansen.checkout.service.PromotionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/promotions")
public class PromotionController {

    private PromotionService promotionService;

    public PromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @GetMapping(value = {""})
    @NotNull
    public Iterable<Promotion> getPromotions(){
        synchronized (this.promotionService){
            return this.promotionService.getAllPromotions();
        }
    }
}
