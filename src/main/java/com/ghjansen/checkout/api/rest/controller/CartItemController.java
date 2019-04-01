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

    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @GetMapping(value = {""})
    @NotNull public Iterable<CartItem> getCartItems(){
        synchronized (this.cartItemService){
            return this.cartItemService.getAllCartItems();
        }

    }

    @PostMapping(value = {""})
    @NotNull public CartItem createCartItem(@RequestParam(value="cartId", defaultValue="") Long cartId, @RequestParam(value="quantity", defaultValue="1") Long quantity, @NotEmpty @RequestParam(value="productId") Long productId){
        synchronized (this.cartItemService){
            return this.cartItemService.create(cartId, quantity, productId);
        }
    }

    @GetMapping(value = {"/{id}"})
    @NotNull public CartItem getCartItem(@PathVariable("id") Long id){
        synchronized (this.cartItemService){
            return this.cartItemService.getCartItem(id);
        }
    }

    @DeleteMapping(value = {"/{id}"})
    public void deleteCartItem(@PathVariable("id") Long id){
        synchronized (this.cartItemService){
            this.cartItemService.removeCartItem(id);
        }
    }
}
