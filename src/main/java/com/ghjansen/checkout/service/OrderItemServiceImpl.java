package com.ghjansen.checkout.service;

import com.ghjansen.checkout.api.rest.exception.ResourceNotFoundException;
import com.ghjansen.checkout.persistence.model.OrderItem;
import com.ghjansen.checkout.persistence.repository.OrderItemRepository;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * The implementation of the service
 */
@Service
public class OrderItemServiceImpl implements OrderItemService {

    private OrderItemRepository orderItemRepository;

    public OrderItemServiceImpl(final OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public @NotNull OrderItem save(final OrderItem orderItem) {
        orderItem.setId(this.orderItemRepository.getCandidateId());
        return this.orderItemRepository.save(orderItem);
    }

    @Override
    public @NotNull OrderItem getOrderItem(@Min(value = 1L, message = "Invalid product id") final Long id) {
        return this.orderItemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order item not found"));
    }

    @Override
    public @NotNull Iterable<OrderItem> getAllOrderItems() {
        return this.orderItemRepository.findAll();
    }
}
