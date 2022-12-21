package com.avazon.ecommerce.service;


import com.avazon.ecommerce.repository.OrderProductRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderProductService {

    private OrderProductRepository repository;

    public OrderProductService(OrderProductRepository orderProductRepository) {
        this.repository = orderProductRepository;
    }
}
