package com.avazon.ecommerce.api.controller;

import com.avazon.ecommerce.service.AddressService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Provider;


@RestController
@RequestMapping("addresses")
public class AddressController {

    private AddressService service;

    public AddressController(AddressService addressService) {
        this.service = addressService;
    }

}
