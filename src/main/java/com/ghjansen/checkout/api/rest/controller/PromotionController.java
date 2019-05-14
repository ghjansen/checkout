package com.ghjansen.checkout.api.rest.controller;

import com.ghjansen.checkout.persistence.model.Promotion;
import com.ghjansen.checkout.service.PromotionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/promotions")
public class PromotionController {

    private PromotionService promotionService;

    public PromotionController(final PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @GetMapping(value = {""})
    public @NotNull Iterable<Promotion> getPromotions() {
        return this.promotionService.getAllPromotions();
    }

    @GetMapping(value = {"/{id}"})
    public @NotNull Promotion getPromotion(@PathVariable("id") Long id) {
        return this.promotionService.getPromotion(id);
    }
}
