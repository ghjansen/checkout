package com.ghjansen.checkout.service;

import com.ghjansen.checkout.persistence.model.OrderItem;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
public interface OrderItemService {

    @NotNull OrderItem save(final OrderItem orderItem);
    @NotNull OrderItem getOrderItem(@Min(value = 1L, message = "Invalid product id") final Long id);
    @NotNull Iterable<OrderItem> getAllOrderItems();
}
