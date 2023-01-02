package com.avazon.ecommerce.service;

import com.avazon.ecommerce.api.model.RegistrationBody;
import com.avazon.ecommerce.dto.UserDto;
import com.avazon.ecommerce.model.entity.LocalUser;
import com.avazon.ecommerce.repository.AddressRepository;
import com.avazon.ecommerce.repository.CartRepository;
import com.avazon.ecommerce.repository.UserRepository;
import com.avazon.ecommerce.repository.WebOrderRepository;
import com.avazon.ecommerce.response.UserResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static org.mockito.Mockito.when;

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
    RegistrationBody newReg;


    @BeforeEach
    void setUp() {

        autoCloseable = MockitoAnnotations.openMocks(this);
        userService = new UserService(userRepository, cartRepository, orderRepository, addressRepository);
        user = new LocalUser(1L,"user1@email.com", "password1", "user1");
        newReg = new RegistrationBody("user1@email.com", "password1", "user1");
        UserDto dto = new UserDto("user1@email.com", "password1", "user1");
        UserResponse userResponse;


    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }


    @Test
    void testSetUserByRegistrationBody_AllMatch() {

        //given
        LocalUser setUser = new LocalUser();

        //when
        setUser.setEmail(newReg.getEmail());
        setUser.setPassword(newReg.getPassword());
        setUser.setName(newReg.getName());

        //then
        assertThat(setUser.getName()).isEqualTo(user.getName());
        assertThat(setUser.getEmail()).isEqualTo(user.getEmail());
        assertThat(setUser.getPassword()).isEqualTo(user.getPassword());

    }

    @Test
    void testSetUserByRegistrationBody_NameNotMatch() {

        //given
        LocalUser setUser = new LocalUser();
        RegistrationBody newReg = new RegistrationBody("user1@email.com","password1","differentUser");

        //when
        setUser.setEmail(newReg.getEmail());
        setUser.setPassword(newReg.getPassword());
        setUser.setName(newReg.getName());

        //then
        assertThat(setUser.getName()).isNotEqualTo(user.getName());
        assertThat(setUser.getEmail()).isEqualTo(user.getEmail());
        assertThat(setUser.getPassword()).isEqualTo(user.getPassword());

    }

    @Test
    void testSetUserByRegistrationBody_EmailNotMatch() {

        //given
        LocalUser setUser = new LocalUser();
        RegistrationBody newReg = new RegistrationBody("differentEmail@email.com","password1","user1");

        //when
        setUser.setEmail(newReg.getEmail());
        setUser.setPassword(newReg.getPassword());
        setUser.setName(newReg.getName());

        //then
        assertThat(setUser.getName()).isEqualTo(user.getName());
        assertThat(setUser.getEmail()).isNotEqualTo(user.getEmail());
        assertThat(setUser.getPassword()).isEqualTo(user.getPassword());

    }

    @Test
    void testSetUserByRegistrationBody_PasswordNotMatch() {

        //given
        LocalUser setUser = new LocalUser();
        RegistrationBody newReg = new RegistrationBody("user1@email.com","differentPassword","user1");

        //when
        setUser.setEmail(newReg.getEmail());
        setUser.setPassword(newReg.getPassword());
        setUser.setName(newReg.getName());

        //then
        assertThat(setUser.getName()).isEqualTo(user.getName());
        assertThat(setUser.getEmail()).isEqualTo(user.getEmail());
        assertThat(setUser.getPassword()).isNotEqualTo(user.getPassword());

    }

    @Test
    void testSetUserByRegistrationBody_EmailAndPasswordNotMatch() {

        //given
        LocalUser setUser = new LocalUser();
        RegistrationBody newReg = new RegistrationBody("differentEmail@email.com","differentPassword","user1");

        //when
        setUser.setEmail(newReg.getEmail());
        setUser.setPassword(newReg.getPassword());
        setUser.setName(newReg.getName());

        //then
        assertThat(setUser.getName()).isEqualTo(user.getName());
        assertThat(setUser.getEmail()).isNotEqualTo(user.getEmail());
        assertThat(setUser.getPassword()).isNotEqualTo(user.getPassword());

    }

    @Test
    void testSetUserByRegistrationBody_EmailAndNameNotMatch() {

        //given
        LocalUser setUser = new LocalUser();
        RegistrationBody newReg = new RegistrationBody("differentEmail@email.com","password1","differentUser");

        //when
        setUser.setEmail(newReg.getEmail());
        setUser.setPassword(newReg.getPassword());
        setUser.setName(newReg.getName());

        //then
        assertThat(setUser.getName()).isNotEqualTo(user.getName());
        assertThat(setUser.getEmail()).isNotEqualTo(user.getEmail());
        assertThat(setUser.getPassword()).isEqualTo(user.getPassword());

    }

    @Test
    void testSetUserByRegistrationBody_PasswordAndNameNotMatch() {

        //given
        LocalUser setUser = new LocalUser();
        RegistrationBody newReg = new RegistrationBody("user1@email.com","differentPassword","differentUser");

        //when
        setUser.setEmail(newReg.getEmail());
        setUser.setPassword(newReg.getPassword());
        setUser.setName(newReg.getName());

        //then
        assertThat(setUser.getName()).isNotEqualTo(user.getName());
        assertThat(setUser.getEmail()).isEqualTo(user.getEmail());
        assertThat(setUser.getPassword()).isNotEqualTo(user.getPassword());

    }

    @Test
    void testSetUserByRegistrationBody_AlldNotMatch() {

        //given
        LocalUser setUser = new LocalUser();
        RegistrationBody newReg = new RegistrationBody("differentEmail@email.com","differentPassword","differentUser");

        //when
        setUser.setEmail(newReg.getEmail());
        setUser.setPassword(newReg.getPassword());
        setUser.setName(newReg.getName());

        //then
        assertThat(setUser.getName()).isNotEqualTo(user.getName());
        assertThat(setUser.getEmail()).isNotEqualTo(user.getEmail());
        assertThat(setUser.getPassword()).isNotEqualTo(user.getPassword());

    }



    @Test
    void testReg() {

/*        mock(RegistrationBody.class);
        mock(UserResponse.class);
        mock(UserDto.class);
        mock(UserService.class);
        mock(UserRepository.class);

        UserResponse response = new UserResponse();
        UserResponse responseFromMethod = userService.registerUser(registrationBody);
        UserResponse testResponse = new UserResponse(dto, new Meta(1001, "PASSED"));
        response.setUser(userRepository.save(user).toDto());
        Cart cart = new Cart();
        cart.setUser(user);
        cartRepository.save(cart);
        //return response;*/
    }


    @Test
    void loginUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }

    @Test
    void testGetUserEntity_Found() {

        //mock(LocalUser.class);
        //mock(UserRepository.class);
        LocalUser userTest = new LocalUser();

        when(userRepository.findById(1L)).thenReturn(Optional.ofNullable(userTest));
        assertThat(userService.getUserEntity(1L).get().getEmail())
                .isEqualTo(userTest.getEmail());
    }

    @Test
    void testGetUserEntity_NotFound() {

        LocalUser userTest = new LocalUser();

        when(userRepository.findById(1L))
                .thenReturn(Optional.ofNullable(userTest));

        assertThat(userService.getUserEntity(1L).get())
                .isNotEqualTo(null);
    }

}