package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {
    UserRepository userRepository;
    @BeforeEach
    void setUp() {
        userRepository = new UserRepository(List.of(
                new User("ivan", "ivanov", true),
                new User("stas", "petrov", false),
                new User("anton", "sidorov", false)));;

    }

    @AfterEach
    void tearDown() {
        userRepository=null;
    }

    @Test
    @DisplayName("addition users in repository test")
    void addUser() {
        userRepository = new UserRepository();
        User user1= new User("ivan", "ivanov", true);
        User user2= new User("stas", "petrov", false);
        User user3= new User("anton", "sidorov", false);
        user1.authenticate("ivan", "ivanov");
            userRepository.addUser(user1);

        user2.authenticate("stas", "petrov");
            userRepository.addUser(user2);

        user3.authenticate("randomname", "sidorov");
            userRepository.addUser(user3);

        List<User> testUserList = new ArrayList<>(List.of(
                new User("ivan", "ivanov", true),
                new User("stas", "petrov", false)));

        assertArrayEquals(testUserList.toArray(), userRepository.getData().toArray());
    }

    @Test
    @DisplayName("test search in repository")
    void findByName() {
        assertEquals(true, userRepository.findByName("ivan"));
        assertEquals(false, userRepository.findByName("randomName"));
    }

    @Test
    void logOutIfNotAdmin() {
        assertArrayEquals(
                List.of(
                        new User("ivan", "ivanov", true),
                        new User("stas", "petrov", false),
                        new User("anton", "sidorov", false)). toArray(),
                userRepository.getData().toArray() );
        userRepository.logOutIfNotAdmin();
        assertArrayEquals(List.of( new User("ivan", "ivanov", true)).toArray(),userRepository.getData().toArray() );
    }
}