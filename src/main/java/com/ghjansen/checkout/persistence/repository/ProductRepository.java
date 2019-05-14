package com.ghjansen.checkout.persistence.repository;

import com.ghjansen.checkout.persistence.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
