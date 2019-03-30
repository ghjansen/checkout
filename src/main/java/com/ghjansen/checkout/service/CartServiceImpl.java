package com.ghjansen.checkout.service;

import com.ghjansen.checkout.api.rest.exception.ResourceNotFoundException;
import com.ghjansen.checkout.persistence.model.Cart;
import com.ghjansen.checkout.persistence.repository.CartRepository;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Service
public class CartServiceImpl implements CartService {

    private CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart save(final Cart cart) {
        cart.setId(this.cartRepository.getCandidateId());
        return cartRepository.save(cart);
    }

    @Override
    public Cart create() {
        return save(new Cart());
    }

    @Override
    public Cart getCart(@Min(value = 1L, message = "Ivalid cart id") final Long id) {
        return this.cartRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cart not found"));
    }

    @Override
    public @NotNull Iterable<Cart> getAllCarts() {
        return this.cartRepository.findAll();
    }
}
