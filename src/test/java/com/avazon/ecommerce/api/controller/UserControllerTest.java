package com.avazon.ecommerce.api.controller;

import com.avazon.ecommerce.api.model.RegistrationBody;
import com.avazon.ecommerce.exception.FieldsMissingException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {

    @BeforeEach
    void setUp() {


    }

    @AfterEach
    void tearDown() {


    }

    @Test
    void registerUser() {
    }

    @Test
    void loginUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void testCheckRegistrationBody_EmailNull() {

         /*   //Throwable exception =
            assertThrows(FieldsMissingException.class, new Executable() {
                @Override
                public void execute() throws Throwable {
                    RegistrationBody registrationBody1 = new RegistrationBody(null,"password1","name1");
                    //userService.checkRegistrationBody(registrationBody1);
                }
            });
            //assertEquals("All fields should have been filled, please check!!",exception.getMessage());
         */
    }


}