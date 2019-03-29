package com.ghjansen.checkout.service;

import com.ghjansen.checkout.persistence.model.Cart;
import com.ghjansen.checkout.persistence.repository.CartRepository;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CartServiceImpl implements CartService {

    private CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart save(Cart cart) {
        return null;
    }

    @Override
    public Cart getCart(@Min(value = 1L, message = "Ivalid cart id") final Long id) {
        return null;
    }

    @Override
    public @NotNull Iterable<Cart> getAllCarts() {
        return null;
    }
}
