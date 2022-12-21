package com.avazon.ecommerce.service;


import com.avazon.ecommerce.repository.WebOrderRepository;
import org.springframework.stereotype.Service;

@Service
public class WebOrderService {

    private WebOrderRepository repository;

    public WebOrderService(WebOrderRepository webOrderRepository) {
        this.repository = webOrderRepository;
    }


}
