package com.ghjansen.checkout.service;

import com.ghjansen.checkout.persistence.model.Product;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
public interface ProductService {

    Product save(final Product product);
    Product getProduct(@Min(value = 1L, message = "Invalid product id") final Long id);
    @NotNull Iterable<Product> getAllProducts();

}
