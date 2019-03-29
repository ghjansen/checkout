package com.ghjansen.checkout;

import com.ghjansen.checkout.persistence.repository.CartItemRepository;
import com.ghjansen.checkout.persistence.repository.CartRepository;
import com.ghjansen.checkout.persistence.repository.ProductRepository;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
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
