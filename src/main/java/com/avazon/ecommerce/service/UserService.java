package com.avazon.ecommerce.service;

import com.avazon.ecommerce.api.model.RegistrationBody;
import com.avazon.ecommerce.exception.AuthFieldsMissingException;
import com.avazon.ecommerce.exception.UserAlreadyExistException;
import com.avazon.ecommerce.model.entity.LocalUser;
import com.avazon.ecommerce.repository.UserRepository;
import com.avazon.ecommerce.response.AuthResponse;
import jakarta.persistence.EntityExistsException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository repository;

    public UserService(UserRepository userRepository) {
        this.repository = userRepository;
    }

    public AuthResponse registerUser(RegistrationBody registrationBody) throws UserAlreadyExistException,
            AuthFieldsMissingException {
        if(repository.findByEmail(registrationBody.getEmail()).isPresent()){
            throw new UserAlreadyExistException("Email is already used, please try different e-mail!");
        }
        if (registrationBody.getName()==null || registrationBody.getName().equals("") ||
                registrationBody.getEmail()==null || registrationBody.getEmail().equals("") ||
                registrationBody.getPassword()==null || registrationBody.getPassword().equals("")) {
            throw new AuthFieldsMissingException("All fields should have been filled, please check!!");
        }
        LocalUser user = new LocalUser();
        user.setEmail(registrationBody.getEmail());
        //TODO: Encypt password!!
        user.setPassword(registrationBody.getPassword());
        user.setName(registrationBody.getName());
        AuthResponse response = new AuthResponse();
        response.setUserAuth(repository.save(user).toDtoForAuth());
        return response;
    }


}
