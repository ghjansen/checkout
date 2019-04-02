package com.ghjansen.checkout.api.rest.controller;

import com.ghjansen.checkout.persistence.model.OrderItem;
import com.ghjansen.checkout.service.OrderItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * The order item controller that handles REST requests
 */
@RestController
@RequestMapping("/api/orderitems")
public class OrderItemController {

    private OrderItemService orderItemService;

    public OrderItemController(final OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @GetMapping(value = {""})
    public @NotNull Iterable<OrderItem> getOrderItems(){
        synchronized (this.orderItemService){
            return this.orderItemService.getAllOrderItems();
        }
    }

    @GetMapping(value = {"/{id}"})
    public @NotNull OrderItem getOrderItem(@PathVariable("id") Long id){
        synchronized (this.orderItemService){
            return this.orderItemService.getOrderItem(id);
        }
    }
}
