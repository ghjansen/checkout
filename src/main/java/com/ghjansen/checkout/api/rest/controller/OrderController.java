package com.ghjansen.checkout.api.rest.controller;

import com.ghjansen.checkout.persistence.model.Order;
import com.ghjansen.checkout.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private OrderService orderService;

    public OrderController(final OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = {""})
    public @NotNull Iterable<Order> getOrders() {
        return this.orderService.getAllOrders();
    }

    @GetMapping(value = {"/{id}"})
    public @NotNull Order getOrder(@PathVariable("id") Long id) {
        return this.orderService.getOrder(id);
    }


}
