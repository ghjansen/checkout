package com.ghjansen.checkout.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Transient;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class CartItem extends Promotional {

    @EmbeddedId
    @JsonIgnore
    private CartItemPK pk;
    @NotNull(message = "Cart item quantity is required")
    @Column(nullable = false)
    private Long quantity;

    public CartItem(Cart cart, Product product, @NotNull(message = "Cart item quantity is required") Long quantity) {
        this.pk = new CartItemPK();
        this.pk.setCart(cart);
        this.pk.setProduct(product);
        this.quantity = quantity;
    }

    public CartItem() {
        super();
    }

    public CartItemPK getPk() {
        return pk;
    }

    public void setPk(CartItemPK pk) {
        this.pk = pk;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Transient
    @JsonIgnore
    public Cart getCart() {
        return this.pk.getCart();
    }

    @Transient
    public Long getCartId() {
        return this.pk.getCart().getId();
    }

    @Transient
    public Product getProduct() {
        return this.pk.getProduct();
    }
}
