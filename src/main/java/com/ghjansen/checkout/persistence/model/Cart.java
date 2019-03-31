package com.ghjansen.checkout.persistence.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Entity {

    @NotNull(message = "Cart id is required")
    private Long id;
    @NotNull(message = "Cart date created is required")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS z")
    private ZonedDateTime dateCreated;
    @NotNull(message = "Cart status is required")
    private String status;
    @NotNull(message = "Cart items is required")
    private List<CartItem> cartItems;
    @NotNull(message = "Cart promotions is required")
    private List<Promotion> promotions;
    @NotNull(message = "Cart total price is required")
    private Double totalPrice;

    public Cart() {
        this.dateCreated = ZonedDateTime.now(ZoneId.of("UTC"));
        this.status = Status.open.name();
        this.cartItems = new ArrayList<>();
        this.promotions = new ArrayList<>();
        this.totalPrice = 0D;
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

    public List<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(final List<Promotion> promotions) {
        this.promotions = promotions;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(final Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public enum Status {
        open,
        closed
    }
}
