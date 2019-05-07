package com.ghjansen.checkout.service;

import com.ghjansen.checkout.api.rest.exception.ResourceNotFoundException;
import com.ghjansen.checkout.persistence.model.Order;
import com.ghjansen.checkout.persistence.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public @NotNull Order save(final Order order) {
        return this.orderRepository.save(order);
    }

    @Override
    public @NotNull Order create() {
        Order order = new Order();
        order.setCartId(0L);
        order.setDateCreated(ZonedDateTime.now(ZoneId.of("UTC")));
        order.setOrderItems(new ArrayList<>());
        order.setPromotions(new ArrayList<>());
        order.setTotalPrice(0D);
        return save(new Order());
    }

    @Override
    public @NotNull Order getOrder(@Min(value = 1L, message = "Invalid order id") final Long id) {
        return this.orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order not found"));
    }

    @Override
    public @NotNull Iterable<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }
}
