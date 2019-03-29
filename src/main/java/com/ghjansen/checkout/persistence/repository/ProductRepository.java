package com.ghjansen.checkout.persistence.repository;

import com.ghjansen.checkout.persistence.model.Product;

import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * This class handles DAO operations and emulates a database table in memory. <p>
 * In order to have the repository integrated with a database like H2, this class
 * must be converted to an empty interface and extends org.springframework.data.repository.CrudRepository,
 * thus eliminating the need to be configured as a bean at {@link com.ghjansen.checkout.CheckoutConfiguration}.
 */
public class ProductRepository {

    private final AtomicLong counter;
    private final HashMap<Long, Product> products;

    public ProductRepository() {
        this.counter = new AtomicLong();
        this.products = new HashMap<Long, Product>();
    }

    public Product save(final Product product){
        product.setId(this.counter.incrementAndGet());
        this.products.put(product.getId(), product);
        return product;
    }

    public Optional<Product> findById(final Long id){
        return Optional.ofNullable(this.products.get(id));
    }

    public Iterable<Product> findAll(){
        return this.products.values();
    }

    public void delete(final Product product){
        this.products.remove(product.getId());
    }

    public void deleteById(final Long id){
        this.products.remove(id);
    }

}
