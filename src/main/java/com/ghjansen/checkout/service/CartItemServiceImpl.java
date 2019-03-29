package com.ghjansen.checkout.service;

import com.ghjansen.checkout.persistence.model.CartItem;
import com.ghjansen.checkout.persistence.repository.CartItemRepository;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CartItemServiceImpl implements CartItemService {

    private CartItemRepository cartItemRepository;

    public CartItemServiceImpl(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public CartItem save(CartItem cartItem) {
        return null;
    }

    @Override
    public CartItem getCartItem(@Min(value = 1L, message = "Ivalid cart item id") final Long id) {
        return null;
    }

    @Override
    public @NotNull Iterable<CartItem> getAllCartItems() {
        return null;
    }
}
