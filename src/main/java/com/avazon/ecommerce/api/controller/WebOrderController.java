package com.avazon.ecommerce.api.controller;


import com.avazon.ecommerce.service.WebOrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orders")
public class WebOrderController {

    private WebOrderService service;

    public WebOrderController(WebOrderService webOrderService) {
        this.service = webOrderService;
    }

}
