package com.ghjansen.checkout.service;

import com.ghjansen.checkout.persistence.model.CartItem;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
public interface CartItemService {

    CartItem save(final CartItem cartItem);
    @NotNull CartItem create(final Long cartId, @Min(value = 1L, message = "Ivalid cart item quantity") final Long quantity, @Min(value = 1L, message = "Ivalid cart item product id") final Long productId);
    CartItem getCartItem(@Min(value = 1L, message = "Ivalid cart item id") final Long id);
    @NotNull Iterable<CartItem> getAllCartItems();
    void removeCartItem(@Min(value = 1L, message = "Ivalid cart item id") final Long id);

}
