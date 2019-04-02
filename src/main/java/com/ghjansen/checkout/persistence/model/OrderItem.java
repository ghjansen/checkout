package com.ghjansen.checkout.persistence.model;

import javax.validation.constraints.NotNull;

public class OrderItem implements Entity {

    @NotNull(message = "Order item id is required")
    private Long id;
    @NotNull(message = "Order item order id is required")
    private Long orderId;
    @NotNull(message = "Order item quantity is required")
    private Long quantity;
    @NotNull(message = "Order item product is required")
    private Product product;

    public OrderItem(@NotNull(message = "Order item order id is required") final Long orderId, @NotNull(message = "Order item quantity is required") final Long quantity, @NotNull(message = "Order item product is required") Product product) {
        this.orderId = orderId;
        this.quantity = quantity;
        this.product = product;
    }

    public OrderItem(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(final Long orderId) {
        this.orderId = orderId;
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
