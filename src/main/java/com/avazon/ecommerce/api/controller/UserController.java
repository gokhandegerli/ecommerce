package com.avazon.ecommerce.api.controller;

import com.avazon.ecommerce.api.model.RegistrationBody;
import com.avazon.ecommerce.exception.RegisterFieldsMissingException;
import com.avazon.ecommerce.exception.LoginFailException;
import com.avazon.ecommerce.exception.UserAlreadyExistException;
import com.avazon.ecommerce.response.UserResponse;
import com.avazon.ecommerce.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    private UserService service;

    public UserController(UserService userService) {
        this.service = userService;
    }

    @PostMapping("/register")
    public UserResponse registerUser(@Valid @RequestBody RegistrationBody registrationBody) {
        try {
            return service.registerUser(registrationBody);
        } catch (UserAlreadyExistException ex) {
            ex.printStackTrace();
            UserResponse failResponse = new UserResponse();
            failResponse.getMeta().setErrorCode(1001);
            failResponse.getMeta().setErrorDescription("This user already registered! " +
                    "Please use a different e-mail!");
            return failResponse;
        } catch (RegisterFieldsMissingException ex) {
            ex.printStackTrace();
            UserResponse failResponse = new UserResponse();
            failResponse.getMeta().setErrorCode(1002);
            failResponse.getMeta().setErrorDescription("Please fill all fields!");
            return failResponse;
        }
    }
    @GetMapping("{email}/{password}")
    public UserResponse loginUser (@PathVariable(value = "email") String email,
                                   @PathVariable(value = "password") String password){
        try {
            return service.loginUser(email, password);
        } catch (LoginFailException ex){
            ex.printStackTrace();
            UserResponse failResponse = new UserResponse();
            failResponse.getMeta().setErrorCode(1003);
            failResponse.getMeta().setErrorDescription("Please correctly fill the email and password fields!");
            return failResponse;
        }
    }




}
