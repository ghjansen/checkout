package com.ghjansen.checkout.api.rest.controller;

import com.ghjansen.checkout.persistence.model.OrderItem;
import com.ghjansen.checkout.service.OrderItemService;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/orderitems")
public class OrderItemController {

    private OrderItemService orderItemService;

    public OrderItemController(final OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @GetMapping(value = {""})
    public @NotNull Iterable<OrderItem> getOrderItemOrList(@RequestParam(value = "orderId", defaultValue = "", required = false) Long orderId, @RequestParam(value = "productId", defaultValue = "", required = false) Long productId) {
        if (orderId != null && productId != null && orderId > 0 && productId > 0) {
            return listOf(getOrderItem(orderId, productId));
        } else {
            return getOrderItems();
        }
    }

    public Iterable<OrderItem> getOrderItems() {
        return this.orderItemService.getAllOrderItems();
    }

    public OrderItem getOrderItem(Long orderId, Long productId) {
        return this.orderItemService.getOrderItem(orderId, productId);
    }

    private Iterable<OrderItem> listOf(OrderItem item) {
        ArrayList<OrderItem> list = new ArrayList<>();
        list.add(item);
        return list;
    }
}
