package com.ghjansen.checkout.service;

import com.ghjansen.checkout.persistence.model.Order;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
public interface OrderService {

    @NotNull Order save(final Order order);
    @NotNull Order create();
    @NotNull Order update(final Order order);
    @NotNull Order getOrder(@Min(value = 1L, message = "Invalid order id") final Long id);
    @NotNull Iterable<Order> getAllOrders();

}
