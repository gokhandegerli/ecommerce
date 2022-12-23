package com.avazon.ecommerce.service;

import com.avazon.ecommerce.api.model.RegistrationBody;
import com.avazon.ecommerce.api.model.UserUpdateBody;
import com.avazon.ecommerce.exception.FieldsMissingException;
import com.avazon.ecommerce.exception.LoginFailException;
import com.avazon.ecommerce.exception.AlreadyExistException;
import com.avazon.ecommerce.exception.NotExistException;
import com.avazon.ecommerce.model.entity.LocalUser;
import com.avazon.ecommerce.repository.UserRepository;
import com.avazon.ecommerce.response.Meta;
import com.avazon.ecommerce.response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository repository;

    public UserService(UserRepository userRepository) {
        this.repository = userRepository;
    }

    public UserResponse registerUser(RegistrationBody registrationBody) throws AlreadyExistException,
            FieldsMissingException {
        if (repository.findByEmail(registrationBody.getEmail()).isPresent()) {
            throw new AlreadyExistException("Email is already used, please try a different e-mail!");
        }
        if (registrationBody.getName() == null || registrationBody.getName().equals("") ||
                registrationBody.getEmail() == null || registrationBody.getEmail().equals("") ||
                registrationBody.getPassword() == null || registrationBody.getPassword().equals("")) {
            throw new FieldsMissingException("All fields should have been filled, please check!!");
        }
        LocalUser user = new LocalUser();
        user.setEmail(registrationBody.getEmail());
        user.setPassword(registrationBody.getPassword());
        user.setName(registrationBody.getName());
        UserResponse response = new UserResponse();
        response.setUser(repository.save(user).toDto());
        return response;
    }

    public UserResponse loginUser(String email, String password) throws LoginFailException {
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


    public UserResponse updateUser(long userId, UserUpdateBody userUpdateBody) throws NotExistException {

        Optional<LocalUser> opUser = repository.findById(userId);

        if (opUser.isPresent()) {
            LocalUser user = opUser.get();
            UserResponse response = new UserResponse();
            response.setUser(user.toDto());
            if (userUpdateBody.getEmail() != null) {
                user.setEmail(userUpdateBody.getEmail());
                response.getUser().setEmail(user.getEmail());
            }
            if (userUpdateBody.getPassword() != null) {
                user.setPassword(userUpdateBody.getPassword());
                response.getUser().setPassword(user.getPassword());
            }
            if (userUpdateBody.getName() != null) {
                user.setName(userUpdateBody.getName());
                response.getUser().setName(user.getName());
            }
            repository.save(user);
            return response;
        }
        else {
            throw new NotExistException("This user does not exist in DB! Please check your data!");
        }
    }

    public Meta deleteUser(long userId) {

        Optional<LocalUser> userToBeDeleted = repository.findById(userId);

        if (userToBeDeleted.isPresent()) {
            repository.deleteById(userId);
            return new Meta();
        } else {
            return new Meta(1003,"User not exist!");
        }
    }

    public Optional<LocalUser> getUserEntity(long userId) {
        return repository.findById(userId);
    }
}
