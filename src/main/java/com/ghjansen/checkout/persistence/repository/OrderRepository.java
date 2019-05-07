package com.ghjansen.checkout.persistence.repository;

import com.ghjansen.checkout.persistence.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
