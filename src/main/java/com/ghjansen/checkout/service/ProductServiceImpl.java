package com.ghjansen.checkout.service;

import com.ghjansen.checkout.api.rest.exception.ResourceNotFoundException;
import com.ghjansen.checkout.persistence.model.Product;
import com.ghjansen.checkout.persistence.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(final Product product) {
        product.setId(this.productRepository.getCandidateId());
        return this.productRepository.save(product);
    }

    @Override
    public Product getProduct(@Min(value = 1L, message = "Invalid product id") final Long id) {
        return this.productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    @Override
    public @NotNull Iterable<Product> getAllProducts() {
        return this.productRepository.findAll();
    }
}
