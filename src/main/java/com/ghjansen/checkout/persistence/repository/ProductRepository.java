package com.ghjansen.checkout.persistence.repository;

import com.ghjansen.checkout.persistence.model.Product;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * This class handles DAO operations and emulates a database table in memory. <p>
 * In order to have the repository integrated with a database like H2, this class
 * must be converted to an empty interface and extends org.springframework.data.repository.CrudRepository,
 * thus eliminating the need to be configured as a bean at {@link com.ghjansen.checkout.CheckoutConfiguration}.
 */
public class ProductRepository extends Repository<Product> {

    @Override
    public Product save(final Product product){
        product.setId(this.counter.incrementAndGet());
        this.repository.put(product.getId(), product);
        return product;
    }

    @Override
    public Optional<Product> findById(final Long id){
        return Optional.ofNullable(this.repository.get(id));
    }

    @Override
    public Iterable<Product> findAll(){
        return this.repository.values();
    }

    @Override
    public void delete(final Product product){
        this.repository.remove(product.getId());
    }

    @Override
    public void deleteById(final Long id){
        this.repository.remove(id);
    }

}
