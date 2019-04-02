package com.ghjansen.checkout.persistence.model;

import javax.validation.constraints.NotNull;

/**
 * The entity that holds all information about cart item
 */
public class CartItem implements Entity {

    @NotNull(message = "Cart item id is required")
    private Long id;
    @NotNull(message = "Cart item cart id is required")
    private Long cartId;
    @NotNull(message = "Cart item quantity is required")
    private Long quantity;
    @NotNull(message = "Cart item product is required")
    private Product product;

    public CartItem(@NotNull(message = "Cart item id is required") final Long id, @NotNull(message = "Cart item cart id is required") final Long cartId, @NotNull(message = "Cart item quantity is required") final Long quantity, @NotNull(message = "Cart item product is required") final Product product) {
        this.id = id;
        this.cartId = cartId;
        this.quantity = quantity;
        this.product = product;
    }

    public CartItem(@NotNull(message = "Cart item cart id is required") Long cartId, @NotNull(message = "Cart item quantity is required") Long quantity, @NotNull(message = "Cart item product is required") Product product) {
        this.cartId = cartId;
        this.quantity = quantity;
        this.product = product;
    }

    public CartItem(){

    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(final Long cartId) {
        this.cartId = cartId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(final Long quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(final Product product) {
        this.product = product;
    }
}
