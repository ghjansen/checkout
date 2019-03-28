package com.ghjansen.checkout.persistence.repository;

import com.ghjansen.checkout.persistence.model.Product;

import java.util.HashMap;
import java.util.Optional;

/**
 * This class handles DAO operations and emulates a database table in memory.
 * In order to have the repository integrated with a database like H2, this class
 * must be converted to and empty interface and extends CrudRepository<T,ID>, where T is the
 * entity type and ID is the entity's id attribute type.
 */
public class ProductRepository {

    private HashMap<Long, Product> products;

    public ProductRepository() {
        this.products = new HashMap<Long, Product>();
    }

    public Product save(Product product){
        this.products.put(product.getId(), product);
        return this.products.get(product.getId());
    }

    public Optional<Product> findById(long id){
        return Optional.of(this.products.get(id));
    }

    public Iterable<Product> findAll(){
        return this.products.values();
    }
}
