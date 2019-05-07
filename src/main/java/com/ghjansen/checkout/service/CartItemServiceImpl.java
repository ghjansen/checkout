package com.ghjansen.checkout.service;

import com.ghjansen.checkout.api.rest.exception.InvalidStateException;
import com.ghjansen.checkout.api.rest.exception.ResourceNotFoundException;
import com.ghjansen.checkout.persistence.model.Cart;
import com.ghjansen.checkout.persistence.model.CartItem;
import com.ghjansen.checkout.persistence.model.Product;
import com.ghjansen.checkout.persistence.repository.CartItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Service
@Transactional
public class CartItemServiceImpl implements CartItemService {

    private CartItemRepository cartItemRepository;
    private CartService cartService;
    private ProductService productService;

    public CartItemServiceImpl(final CartItemRepository cartItemRepository, final CartService cartService, final ProductService productService) {
        this.cartItemRepository = cartItemRepository;
        this.cartService = cartService;
        this.productService = productService;
    }

    @Override
    public @NotNull CartItem save(final CartItem cartItem) {
        return this.cartItemRepository.save(cartItem);
    }

    @Override
    public @NotNull CartItem create(final Long cartId, @Min(value = 1L, message = "Ivalid cart item quantity") final Long quantity, @Min(value = 1L, message = "Ivalid cart item product id") final Long productId) {
        final Cart cart = getExistentOrNewCart(cartId);
        this.cartService.preventClosedCartChanges(cart);
        final Product product = this.productService.getProduct(productId);
        preventDuplicateCartItem(cart, product);
        final CartItem cartItem = new CartItem();
        cartItem.setCartId(cart.getId());
        cartItem.setQuantity(quantity);
        cartItem.setProduct(product);
        save(cartItem);
        cart.getCartItems().add(cartItem);
        this.cartService.update(cart);
        return cartItem;
    }

    @Override
    public @NotNull CartItem getCartItem(@Min(value = 1L, message = "Ivalid cart item id") final Long id) {
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
        this.cartService.preventClosedCartChanges(cart);
        cart.getCartItems().remove(cartItem);
        this.cartService.update(cart);
        this.cartItemRepository.delete(cartItem);
    }

    private Cart getExistentOrNewCart(Long cartId) {
        if (cartId != null) {
            return this.cartService.getCart(cartId);
        } else {
            return this.cartService.create();
        }
    }

    @SuppressWarnings("unchecked")
    private <X extends Throwable> void preventDuplicateCartItem(Cart c, Product p) throws X {
        for (CartItem i : c.getCartItems()) {
            if (i.getProduct().getId().equals(p.getId())) {
                throw (X) new InvalidStateException("The product " +
                        p.getId() + " was already included in the cart " +
                        c.getId() + " through the cart item " +
                        i.getId());
            }
        }
    }
}
