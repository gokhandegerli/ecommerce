package com.avazon.ecommerce.repository;


import com.avazon.ecommerce.model.entity.LocalUser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class UserRepositoryTest {

    // given - when - then

    @Autowired
    UserRepository userRepository;

    LocalUser user;

    @BeforeEach
    void setUp() {
        user = new LocalUser("user1@email.com", "password1", "user1");
        user = userRepository.save(user);
    }


    /*    @AfterEach
    void tearDown() {

        user = null;
        userRepository.deleteAll();
    }*/


    //Test case SUCCESS
    @Test
    void testFindByEmail_Found() {
        Optional<LocalUser> foundUser = userRepository.findByEmail("user1@email.com");
        assertThat(foundUser.get().getId()).isEqualTo(user.getId());
        assertThat(foundUser.get().getEmail()).isEqualTo(user.getEmail());
    }

    //Test case FAILURE
    @Test
    void testFindByEmail_NotFound() {
        Optional<LocalUser> foundUser2 = userRepository.findByEmail("user2@email.com");
        assertThat(foundUser2.isEmpty()).isTrue();
    }

    //Test case SUCCESS
    @Test
    void testFindByEmailAndPassword_Found() {
        Optional<LocalUser> foundUser = userRepository.findByEmailAndPassword("user1@email.com", "password1");
        assertThat(foundUser.get().getName()).isEqualTo(user.getName());

    }

    @Test
    void testFindByEmailAndPasswordWithWrongEmail_NotFound() {
        Optional<LocalUser> foundUser = userRepository.findByEmailAndPassword("test@email.com", "password1");
        assertThat(foundUser.isEmpty()).isTrue();
    }

    @Test
    void testFindByEmailAndPasswordWithWrongPassword_NotFound() {
        Optional<LocalUser> foundUser = userRepository.findByEmailAndPassword("user1@email.com", "test");
        assertThat(foundUser.isEmpty()).isTrue();
    }

    @Test
    void testFindByEmailAndPasswordWithWrongEmailAndPassword_NotFound() {
        Optional<LocalUser> foundUser = userRepository.findByEmailAndPassword("test@email.com", "test");
        assertThat(foundUser.isEmpty()).isTrue();
    }

}
