package com.avazon.ecommerce.api.controller;

import com.avazon.ecommerce.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProductController {

    private ProductService service;

    public ProductController(ProductService productService) {
        this.service = productService;
    }

}
