package com.ghjansen.checkout.persistence.repository;

import com.ghjansen.checkout.persistence.model.CartItem;
import com.ghjansen.checkout.persistence.model.CartItemPK;
import org.springframework.data.repository.CrudRepository;

import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public interface CartItemRepository extends CrudRepository<CartItem, CartItemPK> {

}