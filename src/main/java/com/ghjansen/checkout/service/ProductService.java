package com.ghjansen.checkout.service;

import com.ghjansen.checkout.persistence.model.Product;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * The definition of the service to be used synchronously by other services and by its own controller
 */
@Validated
public interface ProductService {

    @NotNull Product save(final Product product);
    @NotNull Product getProduct(@Min(value = 1L, message = "Invalid product id") final Long id);
    @NotNull Iterable<Product> getAllProducts();

}
