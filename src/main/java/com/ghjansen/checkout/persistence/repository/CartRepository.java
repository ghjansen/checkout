package com.ghjansen.checkout.persistence.repository;

import com.ghjansen.checkout.persistence.model.Cart;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CartRepository extends CrudRepository<Cart, Long> {

}
