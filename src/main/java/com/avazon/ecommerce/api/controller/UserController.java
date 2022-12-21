package com.avazon.ecommerce.api.controller;

import com.avazon.ecommerce.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customers")
public class UserController {

    private UserService service;

    public UserController(UserService userService) {
        this.service = userService;
    }





}
