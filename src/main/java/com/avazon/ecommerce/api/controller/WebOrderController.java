package com.avazon.ecommerce.api.controller;


import com.avazon.ecommerce.api.model.RegistrationBody;
import com.avazon.ecommerce.exception.AlreadyExistException;
import com.avazon.ecommerce.exception.FieldsMissingException;
import com.avazon.ecommerce.exception.NotExistException;
import com.avazon.ecommerce.response.UserResponse;
import com.avazon.ecommerce.response.WebOrderResponse;
import com.avazon.ecommerce.service.WebOrderService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("orders")
public class WebOrderController {

    private WebOrderService service;

    public WebOrderController(WebOrderService webOrderService) {
        this.service = webOrderService;
    }



    @PostMapping("checkout-cart/{cartId}")
    public WebOrderResponse checkoutCart(@PathVariable (value="cartId") long cartId) {

        return service.checkoutCart(cartId);
    }


}
