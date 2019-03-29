package com.ghjansen.checkout.persistence.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class Cart {

    @NotNull(message = "Cart id is required")
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS z")
    private ZonedDateTime dateCreated;
    private String status;
    private List<CartItem> cartItems;

    public Cart() {
        this.dateCreated = ZonedDateTime.now(ZoneId.of("UTC"));
        this.status = Status.open.name();
        this.cartItems = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public ZonedDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(final ZonedDateTime dateCreated) {
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
