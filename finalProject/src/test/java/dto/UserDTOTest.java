package dto;

import org.example.project.dto.UserDTO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserDTOTest {

    @Test
    public void testGettersAndSetters() {
        UserDTO dto = new UserDTO();
        dto.setId(1L);
        dto.setUsername("john_doe");
        dto.setEmail("john.doe@example.com");
        dto.setPassword("password123");

        assertEquals(1L, dto.getId());
        assertEquals("john_doe", dto.getUsername());
        assertEquals("john.doe@example.com", dto.getEmail());
        assertEquals("password123", dto.getPassword());
    }

    @Test
    public void testAllArgsConstructor() {
        UserDTO dto = new UserDTO(1L, "john_doe", "john.doe@example.com", "password123");

        assertEquals(1L, dto.getId());
        assertEquals("john_doe", dto.getUsername());
        assertEquals("john.doe@example.com", dto.getEmail());
        assertEquals("password123", dto.getPassword());
    }

    // Если вы включили пароль в DTO, рассмотрите возможность написания теста, который проверяет шифрование пароля.
    // Обратите внимание, что в продакшн-коде пароли не должны передаваться и храниться в открытом виде!
}
