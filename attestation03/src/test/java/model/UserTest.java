package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @Test
    void testUserGettersAndSetters() {
        user.setId(1L);
        user.setUsername("testUser");
        user.setEmail("testUser@example.com");
        user.setPassword("securePassword");

        assertEquals(1L, user.getId());
        assertEquals("testUser", user.getUsername());
        assertEquals("testUser@example.com", user.getEmail());
        assertEquals("securePassword", user.getPassword());
    }

    @Test
    void testUserAllArgsConstructor() {
        user = new User(1L, "testUser", "testUser@example.com", "securePassword");

        assertEquals(1L, user.getId());
        assertEquals("testUser", user.getUsername());
        assertEquals("testUser@example.com", user.getEmail());
        assertEquals("securePassword", user.getPassword());
    }
}
