package com.ghjansen.checkout;

import com.ghjansen.checkout.persistence.repository.CartItemRepository;
import com.ghjansen.checkout.persistence.repository.CartRepository;
import com.ghjansen.checkout.persistence.repository.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CheckoutConfiguration {

    @Bean
    public ProductRepository productRepository(){
        return new ProductRepository();
    }

    @Bean
    public CartRepository cartRepository() {
        return new CartRepository();
    }

    @Bean
    public CartItemRepository cartItemRepository(){
        return new CartItemRepository();
    }

}
