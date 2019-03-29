package com.ghjansen.checkout.persistence.repository;

import com.ghjansen.checkout.persistence.model.CartItem;

import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * This class handles DAO operations and emulates a database table in memory. <p>
 * In order to have the repository integrated with a database like H2, this class
 * must be converted to an empty interface and extends org.springframework.data.repository.CrudRepository,
 * thus eliminating the need to be configured as a bean at {@link com.ghjansen.checkout.CheckoutConfiguration}.
 */
public class CartItemRepository {

    private final AtomicLong counter;
    private final HashMap<Long, CartItem> cartItems;

    public CartItemRepository() {
        this.counter = new AtomicLong();
        this.cartItems= new HashMap<>();
    }

    public CartItem save(final CartItem cartItem){
        cartItem.setId(counter.incrementAndGet());
        this.cartItems.put(cartItem.getId(), cartItem);
        return cartItem;
    }

    public Optional<CartItem> findById(final Long id){
        return Optional.of(this.cartItems.get(id));
    }

    public Iterable<CartItem> findAll(){
        return this.cartItems.values();
    }

    public void delete(final CartItem cartItem){
        this.cartItems.remove(cartItem.getId());
    }

    public void deleteById(final Long id){
        this.cartItems.remove(id);
    }
}