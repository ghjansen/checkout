package com.ghjansen.checkout.persistence.repository;

import com.ghjansen.checkout.persistence.model.Product;

import java.util.HashMap;
import java.util.Optional;

/**
 * This class handles DAO operations and emulates a database table in memory. <p>
 * In order to have the repository integrated with a database like H2, this class
 * must be converted to an empty interface and extends org.springframework.data.repository.CrudRepository,
 * thus eliminating the need to be configured as a bean at {@link com.ghjansen.checkout.CheckoutConfiguration}.
 */
public class ProductRepository {

    private HashMap<String, Product> products;

    public ProductRepository() {
        this.products = new HashMap<String, Product>();
    }

    public Product save(Product product){
        this.products.put(product.getCode(), product);
        return this.products.get(product.getCode());
    }

    public Optional<Product> findById(String code){
        return Optional.of(this.products.get(code));
    }

    public Iterable<Product> findAll(){
        return this.products.values();
    }
}
