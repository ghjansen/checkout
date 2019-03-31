package com.ghjansen.checkout.service;

import com.ghjansen.checkout.persistence.model.Cart;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
public interface CartService {

    Cart save(final Cart cart);
    @NotNull Cart create();
    @NotNull Cart update(final Cart cart);
    Cart getCart(@Min(value = 1L, message = "Ivalid cart id") final Long id);
    @NotNull Iterable<Cart> getAllCarts();

}
