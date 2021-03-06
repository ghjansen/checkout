package com.ghjansen.checkout.service;

import com.ghjansen.checkout.api.rest.exception.ResourceNotFoundException;
import com.ghjansen.checkout.persistence.model.*;
import com.ghjansen.checkout.persistence.repository.CartPromotionRepository;
import com.ghjansen.checkout.persistence.repository.PromotionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Service
@Transactional
public class PromotionServiceImpl implements PromotionService {

    private PromotionRepository promotionRepository;
    private CartPromotionRepository cartPromotionRepository;

    public PromotionServiceImpl(final PromotionRepository promotionRepository, final CartPromotionRepository cartPromotionRepository) {
        this.promotionRepository = promotionRepository;
        this.cartPromotionRepository = cartPromotionRepository;
    }

    @Override
    public @NotNull Promotion save(final Promotion promotion) {
        return this.promotionRepository.save(promotion);
    }

    @Override
    public @NotNull Promotion getPromotion(@Min(value = 1L, message = "Invalid promotion id") final Long id) {
        return this.promotionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Promotion not found"));
    }

    @Override
    public @NotNull Iterable<Promotion> getAllPromotions() {
        return this.promotionRepository.findAll();
    }

    @Override
    public @NotNull Cart applyPromotions(Cart cart) {
        this.cartPromotionRepository.deleteCartPromotions(cart.getId());
        cart.getCartPromotions().clear();
        Iterable<Promotion> promotions = getAllPromotions();
        Iterable<CartItem> items = cart.getCartItems();
        HashMap<Promotional, Promotional> index = new HashMap<>();
        for (CartItem c : items) {
            index = checkEligibility(c, promotions, index);
        }
        return calculateCartTotalPrice(cart, index);
    }

    private HashMap<Promotional, Promotional> checkEligibility(CartItem c, Iterable<Promotion> promotions, HashMap<Promotional, Promotional> index) {
        boolean isPromotional = false;
        //if the product in the item cart IS EQUALS TO the product of a promotion, account it as promotional item
        for (Promotion p : promotions) {
            if (c.getProduct().getId().equals(p.getProductId()) && c.getQuantity() >= p.getItemQuantity()) {
                isPromotional = true;
                index.put(p, c);
                break;
            }
        }
        //if the product in the item cart IS NOT EQUALS TO the product of the promotion, account it as a regular item
        if (!isPromotional) {
            index.put(c, c);
        }
        return index;
    }

    private Cart calculateCartTotalPrice(Cart cart, HashMap<Promotional, Promotional> index) {
        Double totalPrice = 0D;
        Iterator it = index.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            CartItem i = (CartItem) pair.getValue();
            if (pair.getKey().getClass().equals(Promotion.class)) {
                Promotion p = (Promotion) pair.getKey();
                CartPromotion cp = new CartPromotion(cart, p);
                this.cartPromotionRepository.save(cp);
                cart.getCartPromotions().add(cp);
                totalPrice += calculatePromotionalItem(p, i);
            } else if (pair.getKey().getClass().equals(CartItem.class)) {
                totalPrice += calculateRegularItem(i);
            }
        }
        cart.setTotalPrice(totalPrice);
        return cart;
    }

    private Double calculatePromotionalItem(Promotion p, CartItem i) {
        Double price = 0D;
        if (p.getGroupedItemQuantityProgression()) {
            int skip = 0;
            while ((i.getQuantity() - skip) % p.getItemQuantity() != 0) skip++;
            Double productRegularPrice = i.getProduct().getValue();
            Double productPromotionalPrice = productRegularPrice * p.getDiscountFactor();
            price = productPromotionalPrice * (i.getQuantity() - skip);
            price += skip * productRegularPrice;

        } else {
            Double productRegularPrice = i.getProduct().getValue();
            Double productPromotionalPrice = productRegularPrice * p.getDiscountFactor();
            price = productPromotionalPrice * i.getQuantity();
        }
        return price;
    }

    private Double calculateRegularItem(CartItem i) {
        return i.getQuantity() * i.getProduct().getValue();
    }
}