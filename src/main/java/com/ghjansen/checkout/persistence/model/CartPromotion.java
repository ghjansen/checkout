package com.ghjansen.checkout.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Transient;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class CartPromotion {

    @EmbeddedId
    @JsonIgnore
    private CartPromotionPK pk;

    public CartPromotion(Cart cart, Promotion promotion) {
        this.pk = new CartPromotionPK();
        this.pk.setCart(cart);
        this.pk.setPromotion(promotion);
    }

    public CartPromotion() {
        super();
    }

    public CartPromotionPK getPk() {
        return pk;
    }

    public void setPk(CartPromotionPK pk) {
        this.pk = pk;
    }

    @Transient
    public Cart getCart(){
        return this.pk.getCart();
    }

    @Transient
    public Promotion getPromotion(){
        return this.pk.getPromotion();
    }
}
