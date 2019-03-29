package com.ghjansen.checkout.persistence.model;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cart {

    @NotNull(message = "Cart id is required")
    private Long id;
    private LocalDate dateCreated;
    private String status;
    private List<CartItem> cartItems;

    public Cart() {
        this.dateCreated = LocalDate.now();
        this.status = Status.open.name();
        this.cartItems = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(final LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(final List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
