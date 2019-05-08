package com.ghjansen.checkout.persistence.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Cart date created is required")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS z")
    private ZonedDateTime dateCreated;
    @NotNull(message = "Cart status is required")
    private String status;
    @OneToMany(mappedBy = "pk.cart")
    @Valid
    private List<CartItem> cartItems;
    @NotNull(message = "Cart promotions is required")
    private List<Promotion> promotions;
    @NotNull(message = "Cart total price is required")
    private Double totalPrice;

    public Cart(Long id, @NotNull(message = "Cart date created is required") ZonedDateTime dateCreated, @NotNull(message = "Cart status is required") String status, @Valid List<CartItem> cartItems, @NotNull(message = "Cart promotions is required") List<Promotion> promotions, @NotNull(message = "Cart total price is required") Double totalPrice) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.status = status;
        this.cartItems = cartItems;
        this.promotions = promotions;
        this.totalPrice = totalPrice;
    }

    public Cart() {

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
