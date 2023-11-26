package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user1;
    User user2;

    @BeforeEach
    void setUp() {
        user1= new User("admin", "123", true);
        user2= new User("user", "qwe", false);
    }

    @AfterEach
    void tearDown() {
        user1= null;
        user2=null;
    }

    @Test
    @DisplayName("Authentication check")
    void authenticate() {
        assertEquals(true, user1.authenticate("admin", "123"));
        assertEquals(false, user1.authenticate("ad", "123"));
        assertEquals(false, user1.authenticate("admin", "qwe"));
    }
}