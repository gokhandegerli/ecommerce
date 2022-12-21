package com.avazon.ecommerce.api.controller;

import com.avazon.ecommerce.api.model.RegistrationBody;
import com.avazon.ecommerce.exception.AuthFieldsMissingException;
import com.avazon.ecommerce.exception.UserAlreadyExistException;
import com.avazon.ecommerce.response.AuthResponse;
import com.avazon.ecommerce.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private UserService service;

    public AuthenticationController(UserService userService) {
        this.service = userService;
    }

    @PostMapping("/register")
    public AuthResponse registerUser(@Valid @RequestBody RegistrationBody registrationBody){
       try {
           return service.registerUser(registrationBody);
       } catch (UserAlreadyExistException ex) {
           ex.printStackTrace();
           AuthResponse failResponse = new AuthResponse();
           failResponse.getMeta().setErrorCode(1001);
           failResponse.getMeta().setErrorDescription("This user already registered! " +
                   "Please use a different e-mail!");
           return failResponse;
       } catch (AuthFieldsMissingException ex) {
           ex.printStackTrace();
           AuthResponse failResponse = new AuthResponse();
           failResponse.getMeta().setErrorCode(1002);
           failResponse.getMeta().setErrorDescription("Please fill all fields!");
           return failResponse;
       }

    }
}
