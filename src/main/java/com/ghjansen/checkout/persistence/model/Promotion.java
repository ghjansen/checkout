package com.ghjansen.checkout.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Promotion extends Promotional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Promotion name is required")
    private String name;
    @NotNull(message = "Promotion product id is required")
    private Long productId;
    @NotNull(message = "Promotion item quantity is required")
    private Long itemQuantity;
    @NotNull(message = "Promotion discount factor is required")
    private Double discountFactor;
    @NotNull(message = "Promotion grouped item quantity progression is required")
    private Boolean groupedItemQuantityProgression;

    public Promotion(Long id, @NotNull(message = "Promotion name is required") String name, @NotNull(message = "Promotion product id is required") Long productId, @NotNull(message = "Promotion item quantity is required") Long itemQuantity, @NotNull(message = "Promotion discount factor is required") Double discountFactor, @NotNull(message = "Promotion grouped item quantity progression is required") Boolean groupedItemQuantityProgression) {
        this.id = id;
        this.name = name;
        this.productId = productId;
        this.itemQuantity = itemQuantity;
        this.discountFactor = discountFactor;
        this.groupedItemQuantityProgression = groupedItemQuantityProgression;
    }

    public Promotion() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Long itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public Double getDiscountFactor() {
        return discountFactor;
    }

    public void setDiscountFactor(Double discountFactor) {
        this.discountFactor = discountFactor;
    }

    public Boolean getGroupedItemQuantityProgression() {
        return groupedItemQuantityProgression;
    }

    public void setGroupedItemQuantityProgression(Boolean groupedItemQuantityProgression) {
        this.groupedItemQuantityProgression = groupedItemQuantityProgression;
    }
}