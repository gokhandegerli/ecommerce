package com.avazon.ecommerce.service;

import com.avazon.ecommerce.api.model.RegistrationBody;
import com.avazon.ecommerce.dto.UserDto;
import com.avazon.ecommerce.exception.FieldsMissingException;
import com.avazon.ecommerce.model.entity.LocalUser;
import com.avazon.ecommerce.repository.AddressRepository;
import com.avazon.ecommerce.repository.CartRepository;
import com.avazon.ecommerce.repository.UserRepository;
import com.avazon.ecommerce.repository.WebOrderRepository;
import com.avazon.ecommerce.response.UserResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.mock;

@DataJpaTest
class UserServiceTest {


    @Mock
    UserRepository userRepository;
    @Mock
    private CartRepository cartRepository;
    @Mock
    private WebOrderRepository orderRepository;
    @Mock
    private AddressRepository addressRepository;

    private UserService userService;
    AutoCloseable autoCloseable;
    LocalUser user;

    RegistrationBody registrationBody;


    @BeforeEach
    void setUp() {

        autoCloseable = MockitoAnnotations.openMocks(this);
        userService = new UserService(userRepository, cartRepository, orderRepository, addressRepository);
        user = new LocalUser("user1@email.com", "password1", "user1");
        //registrationBody = new RegistrationBody("", "password1", "user1");
        UserDto dto = new UserDto("user1@email.com", "password1", "user1");
        UserResponse userResponse;


    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testCheckRegistrationBody_EmailNull() {

        //Throwable exception =
        assertThrows(FieldsMissingException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                RegistrationBody registrationBody1 = new RegistrationBody(null,"password1","name1");
                userService.checkRegistrationBody(registrationBody1);
            }
        });
            //assertEquals("All fields should have been filled, please check!!",exception.getMessage());
        }


        @Test
        void testRegisterUser () {
            //given
/*        mock(RegistrationBody.class);
        mock(UserResponse.class);
        mock(UserService.class);
        registrationBody = new RegistrationBody("user1@email.com", "password1", "user1");
        UserResponse testResponse = new UserResponse(dto,new Meta(1001,"PASSED"));

        //when
        UserResponse responseFromMethod = userService.registerUser(registrationBody);*/


        }


        @Test
        void loginUser () {
        }

        @Test
        void updateUser () {
        }

        @Test
        void deleteUser () {
        }

        @Test
        void getUserEntity () {
        }
    }