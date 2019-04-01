package com.ghjansen.checkout.persistence.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

public class Order implements Entity {

    @NotNull(message = "Order id is required")
    private Long id;
    @NotNull(message = "Order cart id is required")
    private Long cartId;
    @NotNull(message = "Order date created is required")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS z")
    private ZonedDateTime dateCreated;
    @NotNull(message = "Order items is required")
    private List<OrderItem> orderItems;
    @NotNull(message = "Order promotions is required")
    private List<Promotion> promotions;
    @NotNull(message = "Order total price is required")
    private Double totalPrice;

    public Order(@NotNull(message = "Order cart id is required") final Long cartId,@NotNull(message = "Order items is required") final List<OrderItem> orderItems, @NotNull(message = "Order promotions is required") final List<Promotion> promotions, @NotNull(message = "Order total price is required") final Double totalPrice) {
        this.cartId = cartId;
        this.dateCreated = ZonedDateTime.now(ZoneId.of("UTC"));
        this.orderItems = orderItems;
        this.promotions = promotions;
        this.totalPrice = totalPrice;
    }

    public Order(){

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

    public ZonedDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(final ZonedDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(final List<OrderItem> orderItems) {
        this.orderItems = orderItems;
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
}
