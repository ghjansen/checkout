package com.ghjansen.checkout.service;

import com.ghjansen.checkout.persistence.model.CartItem;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
public interface CartItemService {

    CartItem save(final CartItem cartItem);
    CartItem getCartItem(@Min(value = 1L, message = "Ivalid cart item id") final Long id);
    @NotNull Iterable<CartItem> getAllCartItems();

}
