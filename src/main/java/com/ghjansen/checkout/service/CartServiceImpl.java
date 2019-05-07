package com.ghjansen.checkout.service;

import com.ghjansen.checkout.api.rest.exception.InvalidStateException;
import com.ghjansen.checkout.api.rest.exception.ResourceNotFoundException;
import com.ghjansen.checkout.persistence.model.Cart;
import com.ghjansen.checkout.persistence.model.CartItem;
import com.ghjansen.checkout.persistence.model.Order;
import com.ghjansen.checkout.persistence.model.OrderItem;
import com.ghjansen.checkout.persistence.repository.CartRepository;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;

@Service
public class CartServiceImpl implements CartService {

    private CartRepository cartRepository;
    private PromotionService promotionService;
    private OrderService orderService;
    private OrderItemService orderItemService;

    public CartServiceImpl(final CartRepository cartRepository, final PromotionService promotionService, final OrderService orderService, final OrderItemService orderItemService) {
        this.cartRepository = cartRepository;
        this.promotionService = promotionService;
        this.orderService = orderService;
        this.orderItemService = orderItemService;
    }

    @Override
    public @NotNull Cart save(final Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public @NotNull Cart create() {
        Cart cart = new Cart();
        cart.setDateCreated(ZonedDateTime.now(ZoneId.of("UTC")));
        cart.setStatus(Cart.Status.open.name());
        cart.setCartItems(new ArrayList<>());
        cart.setPromotions(new ArrayList<>());
        return save(cart);
    }

    @Override
    public @NotNull Cart update(Cart cart) {
        synchronized (this.promotionService){
            cart = this.promotionService.applyPromotions(cart);
            return save(cart);
        }
    }

    @Override
    public @NotNull Cart getCart(@Min(value = 1L, message = "Ivalid cart id") final Long id) {
        return this.cartRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cart not found"));
    }

    @Override
    public @NotNull Iterable<Cart> getAllCarts() {
        return this.cartRepository.findAll();
    }

    @Override
    public @NotNull Cart closeCart(@Min(value = 1L, message = "Ivalid cart id") final Long id) {
        Cart cart = getCart(id);
        preventClosedCartChanges(cart);
        synchronized (this.orderItemService){
            synchronized (this.orderService){
                createOrderFromCart(cart);
                cart.setStatus(Cart.Status.closed.name());
                return save(cart);
            }
        }
    }

    private void createOrderFromCart(Cart cart){
        Order order = this.orderService.create();
        ArrayList<OrderItem> orderItems = new ArrayList<>();
        for(CartItem cartItem : cart.getCartItems()){
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(order.getId());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setProduct(cartItem.getProduct());
            orderItem = this.orderItemService.save(orderItem);
            orderItems.add(orderItem);
        }
        order.setOrderItems(orderItems);
        order.setPromotions(cart.getPromotions());
        order.setTotalPrice(cart.getTotalPrice());
        order.setCartId(cart.getId());
        this.orderService.save(order);
    }

    @SuppressWarnings("unchecked")
    public <X extends Throwable> void preventClosedCartChanges(Cart c) throws X {
        if(c.getStatus().equals(Cart.Status.closed.name())){
            throw (X) new InvalidStateException("Cart " +
                    c.getId() + " was already closed. Requested operation rejected");
        }
    }
}
