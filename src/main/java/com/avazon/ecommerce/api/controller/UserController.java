package com.avazon.ecommerce.api.controller;

import com.avazon.ecommerce.api.model.RegistrationBody;
import com.avazon.ecommerce.api.model.UserUpdateBody;
import com.avazon.ecommerce.exception.FieldsMissingException;
import com.avazon.ecommerce.exception.LoginFailException;
import com.avazon.ecommerce.exception.AlreadyExistException;
import com.avazon.ecommerce.exception.NotExistException;
import com.avazon.ecommerce.response.Meta;
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
        } catch (AlreadyExistException ex) {
            ex.printStackTrace();
            UserResponse failResponse = new UserResponse();
            failResponse.getMeta().setCode(1001);
            failResponse.getMeta().setDescription("This user already registered! " +
                    "Please use a different e-mail!");
            return failResponse;
        } catch (FieldsMissingException ex) {
            ex.printStackTrace();
            UserResponse failResponse = new UserResponse();
            failResponse.getMeta().setCode(1002);
            failResponse.getMeta().setDescription("Please fill all fields!");
            return failResponse;
        }
    }

    @GetMapping("{email}/{password}")
    public UserResponse loginUser(@PathVariable(value = "email") String email,
                                  @PathVariable(value = "password") String password) {
        try {
            return service.loginUser(email, password);
        } catch (LoginFailException ex) {
            ex.printStackTrace();
            UserResponse failResponse = new UserResponse();
            failResponse.getMeta().setCode(1003);
            failResponse.getMeta().setDescription("Please correctly fill the email and password fields!");
            return failResponse;
        }
    }

    @PutMapping("/{userId}")
    public UserResponse updateUser(@Valid @PathVariable(value = "userId") long userId,
                                   @RequestBody UserUpdateBody userUpdateBody) {
        try {
            return service.updateUser(userId, userUpdateBody);
        } catch (NotExistException ex) {
            ex.printStackTrace();
            UserResponse failResponse = new UserResponse();
            failResponse.getMeta().setCode(1004);
            failResponse.getMeta().setDescription("This user does not exist!");
            return failResponse;
        }
    }

/*    @DeleteMapping("{userId}")
    public Meta deleteUser (@PathVariable (value="userId") long userId) {
        return service.deleteUser(userId);
    }*/
}
