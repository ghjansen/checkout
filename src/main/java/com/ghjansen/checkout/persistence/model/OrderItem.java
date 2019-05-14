package com.ghjansen.checkout.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Transient;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class OrderItem {

    @EmbeddedId
    @JsonIgnore
    private OrderItemPK pk;
    @NotNull(message = "Order item quantity is required")
    @Column(nullable = false)
    private Long quantity;


    public OrderItem(Order order, Product product, @NotNull(message = "Order item quantity is required") Long quantity) {
        this.pk = new OrderItemPK();
        this.pk.setOrder(order);
        this.pk.setProduct(product);
        this.quantity = quantity;
    }

    public OrderItem() {
        super();
    }

    public OrderItemPK getPk() {
        return pk;
    }

    public void setPk(OrderItemPK pk) {
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
    public Order getOrder() {
        return this.pk.getOrder();
    }

    @Transient
    public Long getOrderId() {
        return this.pk.getOrder().getId();
    }

    @Transient
    public Product getProduct() {
        return this.pk.getProduct();
    }
}
