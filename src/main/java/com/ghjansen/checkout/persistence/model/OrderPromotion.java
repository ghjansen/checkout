package com.ghjansen.checkout.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Transient;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class OrderPromotion {

    @EmbeddedId
    @JsonIgnore
    private OrderPromotionPK pk;

    public OrderPromotion(Order order, Promotion promotion) {
        this.pk = new OrderPromotionPK();
        this.pk.setOrder(order);
        this.pk.setPromotion(promotion);
    }

    public OrderPromotion(){
        super();
    }

    public OrderPromotionPK getPk() {
        return pk;
    }

    public void setPk(OrderPromotionPK pk) {
        this.pk = pk;
    }

    @Transient
    @JsonIgnore
    public Order getOrder(){
        return this.pk.getOrder();
    }

    @Transient
    public Long getOrderId(){
        return this.pk.getOrder().getId();
    }

    @Transient
    public Promotion getPromotion(){
        return this.pk.getPromotion();
    }
}
