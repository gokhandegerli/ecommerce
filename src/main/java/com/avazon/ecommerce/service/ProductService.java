package com.avazon.ecommerce.service;


import com.avazon.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository repository;

    public ProductService(ProductRepository productRepository) {
        this.repository = productRepository;
    }
}
