package com.ghjansen.checkout.api.rest.controller;

import com.ghjansen.checkout.persistence.model.CartItem;
import com.ghjansen.checkout.service.CartItemService;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/cartitems")
public class CartItemController {

    private CartItemService cartItemService;

    public CartItemController(final CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @GetMapping(value = {""})
    public @NotNull Iterable<CartItem> getCartItemOrList(@RequestParam(value = "cartId", defaultValue = "", required = false) Long cartId, @RequestParam(value = "productId", defaultValue = "", required = false) Long productId) {
        if (cartId != null && productId != null && cartId > 0 && productId > 0) {
            return listOf(getCartItem(cartId, productId));
        } else {
            return getCartItems();
        }
    }

    public CartItem getCartItem(Long cartId, Long productId) {
        return this.cartItemService.getCartItem(cartId, productId);
    }

    public Iterable<CartItem> getCartItems() {
        return this.cartItemService.getAllCartItems();

    }

    @PostMapping(value = {""})
    public @NotNull CartItem createCartItem(@RequestParam(value = "cartId", defaultValue = "") Long cartId, @RequestParam(value = "quantity", defaultValue = "1") Long quantity, @NotEmpty @RequestParam(value = "productId") Long productId) {
        return this.cartItemService.create(cartId, quantity, productId);
    }

    @DeleteMapping(value = {""})
    public void deleteCartItem(@NotEmpty @RequestParam(value = "cartId") Long cartId, @NotEmpty @RequestParam(value = "productId") Long productId) {
        this.cartItemService.removeCartItem(cartId, productId);
    }

    private Iterable<CartItem> listOf(CartItem item) {
        ArrayList<CartItem> list = new ArrayList<>();
        list.add(item);
        return list;
    }

}
