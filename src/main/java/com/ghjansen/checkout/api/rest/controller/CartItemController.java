package com.ghjansen.checkout.api.rest.controller;

import com.ghjansen.checkout.persistence.model.CartItem;
import com.ghjansen.checkout.service.CartItemService;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/cartitems")
public class CartItemController {

    private CartItemService cartItemService;

    public CartItemController(final CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @GetMapping(value = {""})
    public @NotNull Iterable<CartItem> getCartItems() {
        return this.cartItemService.getAllCartItems();

    }

    @PostMapping(value = {""})
    public @NotNull CartItem createCartItem(@RequestParam(value = "cartId", defaultValue = "") Long cartId, @RequestParam(value = "quantity", defaultValue = "1") Long quantity, @NotEmpty @RequestParam(value = "productId") Long productId) {
        return this.cartItemService.create(cartId, quantity, productId);
    }

    @GetMapping(value = {"/{id}"})
    public @NotNull CartItem getCartItem(@PathVariable("id") Long id) {
        return this.cartItemService.getCartItem(id);
    }

    @DeleteMapping(value = {"/{id}"})
    public void deleteCartItem(@PathVariable("id") Long id) {
        this.cartItemService.removeCartItem(id);
    }
}
