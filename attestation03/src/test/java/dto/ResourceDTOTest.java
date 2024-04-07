package dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResourceDTOTest {

    @Test
    public void testGettersAndSetters() {
        ResourceDTO dto = new ResourceDTO();
        dto.setId(1L);
        dto.setTitle("Effective Java");
        dto.setDescription("A programming book about Java best practices");
        dto.setType("Book");
        dto.setUrl("http://example.com/effective-java");
        dto.setCategoryId(10L);

        assertEquals(1L, dto.getId());
        assertEquals("Effective Java", dto.getTitle());
        assertEquals("A programming book about Java best practices", dto.getDescription());
        assertEquals("Book", dto.getType());
        assertEquals("http://example.com/effective-java", dto.getUrl());
        assertEquals(10L, dto.getCategoryId());
    }

    @Test
    public void testAllArgsConstructor() {
        ResourceDTO dto = new ResourceDTO(1L, "Effective Java", "A programming book about Java best practices", "Book", "http://example.com/effective-java", 10L);

        assertEquals(1L, dto.getId());
        assertEquals("Effective Java", dto.getTitle());
        assertEquals("A programming book about Java best practices", dto.getDescription());
        assertEquals("Book", dto.getType());
        assertEquals("http://example.com/effective-java", dto.getUrl());
        assertEquals(10L, dto.getCategoryId());
    }
}
