package com.ghjansen.checkout;

import com.ghjansen.checkout.persistence.model.Product;
import com.ghjansen.checkout.service.CartService;
import com.ghjansen.checkout.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CheckoutApplication {

    public static void main(String args[]){
        SpringApplication.run(CheckoutApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ProductService productService, CartService cartService){
        return args -> {
            productService.save(new Product("VOUCHER", "Voucher", 5.00, "http://placehold.it/200x100"));
            productService.save(new Product("TSHIRT","T-Shirt", 20.00, "http://placehold.it/200x100"));
            productService.save(new Product("MUG","Coffee Mug", 7.50, "http://placehold.it/200x100"));

            cartService.create();
            cartService.create();
            cartService.create();

        };
    }

}
