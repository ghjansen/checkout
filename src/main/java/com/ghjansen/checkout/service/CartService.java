package com.ghjansen.checkout.service;

import com.ghjansen.checkout.persistence.model.Cart;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * The definition of the service to be used synchronously by other services and by its own controller
 */
@Validated
public interface CartService {

    @NotNull Cart save(final Cart cart);
    @NotNull Cart create();
    @NotNull Cart update(final Cart cart);
    @NotNull Cart getCart(@Min(value = 1L, message = "Ivalid cart id") final Long id);
    @NotNull Iterable<Cart> getAllCarts();
    @NotNull Cart closeCart(@Min(value = 1L, message = "Ivalid cart id") final Long id);
    @SuppressWarnings("unchecked")
    public <X extends Throwable> void preventClosedCartChanges(Cart c) throws X;

}
