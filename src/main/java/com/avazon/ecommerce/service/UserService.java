package com.avazon.ecommerce.service;

import com.avazon.ecommerce.api.model.RegistrationBody;
import com.avazon.ecommerce.exception.RegisterFieldsMissingException;
import com.avazon.ecommerce.exception.LoginFailException;
import com.avazon.ecommerce.exception.UserAlreadyExistException;
import com.avazon.ecommerce.model.entity.LocalUser;
import com.avazon.ecommerce.repository.UserRepository;
import com.avazon.ecommerce.response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository repository;

    public UserService(UserRepository userRepository) {
        this.repository = userRepository;
    }

    public UserResponse registerUser(RegistrationBody registrationBody) throws UserAlreadyExistException,
            RegisterFieldsMissingException {
        if (repository.findByEmail(registrationBody.getEmail()).isPresent()) {
            throw new UserAlreadyExistException("Email is already used, please try a different e-mail!");
        }
        if (registrationBody.getName() == null || registrationBody.getName().equals("") ||
                registrationBody.getEmail() == null || registrationBody.getEmail().equals("") ||
                registrationBody.getPassword() == null || registrationBody.getPassword().equals("")) {
            throw new RegisterFieldsMissingException("All fields should have been filled, please check!!");
        }
        LocalUser user = new LocalUser();
        user.setEmail(registrationBody.getEmail());
        user.setPassword(registrationBody.getPassword());
        user.setName(registrationBody.getName());
        UserResponse response = new UserResponse();
        response.setUser(repository.save(user).toDto());
        return response;
    }

    public UserResponse loginUser (String email, String password) throws LoginFailException {
        Optional<LocalUser> opUser = repository.findByEmailAndPassword(email, password);
        if (opUser.isPresent()) {
            LocalUser user = opUser.get();
            UserResponse response = new UserResponse();
            response.getUser().setEmail(user.getEmail());
            response.getUser().setPassword(user.getPassword());
            response.getUser().setName(user.getName());
            return response;
        } else {
            throw new LoginFailException("Missing email or password, please check your data");
        }
    }


}
