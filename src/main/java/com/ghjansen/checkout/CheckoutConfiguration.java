package com.ghjansen.checkout;

import com.ghjansen.checkout.persistence.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring Boot configuration required to load repositories as beans,
 * which would not be necessary if the repositories were implementing
 * the interface org.springframework.data.repository.CrudRepository
 * as they would be automatically loaded as beans.
 */
@Configuration
public class CheckoutConfiguration {

    /*
    @Bean
    public ProductRepository productRepository(){
        return new ProductRepository();
    }
    */
    @Bean
    public CartRepository cartRepository() {
        return new CartRepository();
    }

    @Bean
    public CartItemRepository cartItemRepository(){
        return new CartItemRepository();
    }

    @Bean
    public PromotionRepository promotionRepository(){
        return new PromotionRepository();
    }

    @Bean
    public OrderRepository orderRepository(){
        return new OrderRepository();
    }

    @Bean
    public OrderItemRepository orderItemRepository(){
        return new OrderItemRepository();
    }

}
