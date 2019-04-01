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
    private PromotionService promotionService;

    public CartServiceImpl(final CartRepository cartRepository, final PromotionService promotionService) {
        this.cartRepository = cartRepository;
        this.promotionService = promotionService;
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
    public @NotNull Cart update(Cart cart) {
        synchronized (this.promotionService){
            cart = this.promotionService.applyPromotions(cart);
            return this.cartRepository.update(cart);
        }
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
