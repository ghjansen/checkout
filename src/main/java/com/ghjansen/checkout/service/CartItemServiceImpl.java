package com.ghjansen.checkout.service;

import com.ghjansen.checkout.api.rest.exception.ResourceNotFoundException;
import com.ghjansen.checkout.persistence.model.Cart;
import com.ghjansen.checkout.persistence.model.CartItem;
import com.ghjansen.checkout.persistence.model.Product;
import com.ghjansen.checkout.persistence.repository.CartItemRepository;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Service
public class CartItemServiceImpl implements CartItemService {

    private CartItemRepository cartItemRepository;
    private CartService cartService;
    private ProductService productService;

    public CartItemServiceImpl(CartItemRepository cartItemRepository, CartService cartService, ProductService productService) {
        this.cartItemRepository = cartItemRepository;
        this.cartService = cartService;
        this.productService = productService;
    }

    @Override
    public CartItem save(final CartItem cartItem) {
        cartItem.setId(this.cartItemRepository.getCandidateId());
        this.cartItemRepository.save(cartItem);
        return cartItem;
    }

    @Override
    public @NotNull CartItem create(final Long cartId, @Min(value = 1L, message = "Ivalid cart item quantity") final Long quantity, @Min(value = 1L, message = "Ivalid cart item product id") final Long productId) {
        final Cart cart;
        if(cartId != null){
            cart = this.cartService.getCart(cartId);
        } else {
            cart = this.cartService.create();
        }
        final Product product = this.productService.getProduct(productId);
        final CartItem cartItem = new CartItem(cart.getId(), quantity, product);
        save(cartItem);
        cart.getCartItems().add(cartItem);
        return cartItem;
    }

    @Override
    public CartItem getCartItem(@Min(value = 1L, message = "Ivalid cart item id") final Long id) {
        return this.cartItemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cart item not found"));
    }

    @Override
    public @NotNull Iterable<CartItem> getAllCartItems() {
        return this.cartItemRepository.findAll();
    }

    @Override
    public void removeCartItem(@Min(value = 1L, message = "Ivalid cart item id") final Long id) {
        final CartItem cartItem = getCartItem(id);
        final Cart cart = this.cartService.getCart(cartItem.getCartId());
        cart.getCartItems().remove(cartItem);
        this.cartService.update(cart);
        this.cartItemRepository.delete(cartItem);
    }
}
