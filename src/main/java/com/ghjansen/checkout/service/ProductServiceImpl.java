package com.ghjansen.checkout.service;

import com.ghjansen.checkout.api.rest.exception.ResourceNotFoundException;
import com.ghjansen.checkout.persistence.model.Product;
import com.ghjansen.checkout.persistence.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public @NotNull Product save(final Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public @NotNull Product getProduct(@Min(value = 1L, message = "Invalid product id") final Long id) {
        return this.productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    @Override
    public @NotNull Iterable<Product> getAllProducts() {
        return this.productRepository.findAll();
    }
}
