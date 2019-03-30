package com.ghjansen.checkout.persistence.repository;

import com.ghjansen.checkout.persistence.model.Cart;

import java.util.Optional;

/**
 * This class handles DAO operations and emulates a database table in memory. <p>
 * In order to have the repository integrated with a database like H2, this class
 * must be converted to an empty interface and extends org.springframework.data.repository.CrudRepository,
 * thus eliminating the need to be configured as a bean at {@link com.ghjansen.checkout.CheckoutConfiguration}.
 */
public class CartRepository extends Repository<Cart> {

    @Override
    public Cart save(final Cart cart){
        cart.setId(counter.incrementAndGet());
        this.repository.put(cart.getId(), cart);
        return cart;
    }

    @Override
    public Optional<Cart> findById(final Long id){
        return Optional.ofNullable(this.repository.get(id));
    }

    @Override
    public Iterable<Cart> findAll(){
        return this.repository.values();
    }

    @Override
    public void delete(final Cart cart){
        this.repository.remove(cart.getId());
    }

    @Override
    public void deleteById(final Long id){
        this.repository.remove(id);
    }

}
