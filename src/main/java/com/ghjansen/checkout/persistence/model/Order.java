package com.ghjansen.checkout.persistence.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Order(Long id, @NotNull(message = "Order cart id is required") Long cartId, @NotNull(message = "Order date created is required") ZonedDateTime dateCreated, @NotNull(message = "Order items is required") List<OrderItem> orderItems, @NotNull(message = "Order promotions is required") List<Promotion> promotions, @NotNull(message = "Order total price is required") Double totalPrice) {
        this.id = id;
        this.cartId = cartId;
        this.dateCreated = dateCreated;
        this.orderItems = orderItems;
        this.promotions = promotions;
        this.totalPrice = totalPrice;
    }

    public Order() {
    }

    /*
    public Order(){
        this.cartId = 0L;
        this.dateCreated = ZonedDateTime.now(ZoneId.of("UTC"));
        this.orderItems = new ArrayList<>();
        this.promotions = new ArrayList<>();
        this.totalPrice = 0D;
    }
    */

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
