package com.ghjansen.checkout.persistence.repository;

import com.ghjansen.checkout.persistence.model.OrderItem;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {

}
