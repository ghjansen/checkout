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

}
