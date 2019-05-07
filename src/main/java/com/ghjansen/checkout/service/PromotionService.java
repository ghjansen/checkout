package com.ghjansen.checkout.service;

import com.ghjansen.checkout.persistence.model.Cart;
import com.ghjansen.checkout.persistence.model.Promotion;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
public interface PromotionService {

    @NotNull Promotion save(final Promotion promotion);
    @NotNull Promotion getPromotion(@Min(value = 1L, message = "Invalid promotion id") final Long id);
    @NotNull Iterable<Promotion> getAllPromotions();
    @NotNull Cart applyPromotions(final Cart cart);

}
