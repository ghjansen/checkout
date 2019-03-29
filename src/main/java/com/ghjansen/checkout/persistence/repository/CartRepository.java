package com.ghjansen.checkout.persistence.repository;

import com.ghjansen.checkout.persistence.model.Cart;

import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * This class handles DAO operations and emulates a database table in memory. <p>
 * In order to have the repository integrated with a database like H2, this class
 * must be converted to an empty interface and extends org.springframework.data.repository.CrudRepository,
 * thus eliminating the need to be configured as a bean at {@link com.ghjansen.checkout.CheckoutConfiguration}.
 */
public class CartRepository {

    private final AtomicLong counter;
    private final HashMap<Long, Cart> carts;

    public CartRepository() {
        this.counter = new AtomicLong();
        this.carts= new HashMap<>();
    }

    public Cart save(final Cart cart){
        cart.setId(counter.incrementAndGet());
        this.carts.put(cart.getId(), cart);
        return cart;
    }

    public Optional<Cart> findById(final Long id){
        return Optional.ofNullable(this.carts.get(id));
    }

    public Iterable<Cart> findAll(){
        return this.carts.values();
    }

    public void delete(final Cart cart){
        this.carts.remove(cart.getId());
    }

    public void deleteById(final Long id){
        this.carts.remove(id);
    }
}
