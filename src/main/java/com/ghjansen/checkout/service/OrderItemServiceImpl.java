package com.ghjansen.checkout.service;

import com.ghjansen.checkout.api.rest.exception.ResourceNotFoundException;
import com.ghjansen.checkout.persistence.model.Order;
import com.ghjansen.checkout.persistence.model.OrderItem;
import com.ghjansen.checkout.persistence.model.OrderItemPK;
import com.ghjansen.checkout.persistence.model.Product;
import com.ghjansen.checkout.persistence.repository.OrderItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Service
@Transactional
public class OrderItemServiceImpl implements OrderItemService {

    private OrderItemRepository orderItemRepository;
    private OrderService orderService;
    private ProductService productService;

    public OrderItemServiceImpl(final OrderItemRepository orderItemRepository, final OrderService orderService, final ProductService productService) {
        this.orderItemRepository = orderItemRepository;
        this.orderService = orderService;
        this.productService = productService;
    }

    @Override
    public @NotNull OrderItem save(final OrderItem orderItem) {
        return this.orderItemRepository.save(orderItem);
    }

    @Override
    public @NotNull OrderItem getOrderItem(@Min(value = 1L, message = "Ivalid order item order id") final Long orderId, @Min(value = 1L, message = "Ivalid order item product id") final Long productId) {
        Order order = this.orderService.getOrder(orderId);
        Product product = this.productService.getProduct(productId);
        OrderItemPK pk = new OrderItemPK(order, product);
        return this.orderItemRepository.findById(pk).orElseThrow(() -> new ResourceNotFoundException("Order item not found"));
    }

    @Override
    public @NotNull Iterable<OrderItem> getAllOrderItems() {
        return this.orderItemRepository.findAll();
    }
}
