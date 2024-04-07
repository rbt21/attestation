package dto;

import org.example.project.dto.CategoryDTO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryDTOTest {

    @Test
    public void testGettersAndSetters() {
        CategoryDTO dto = new CategoryDTO();
        dto.setId(1L);
        dto.setName("Education");
        dto.setDescription("Resources for learning");

        assertEquals(1L, dto.getId());
        assertEquals("Education", dto.getName());
        assertEquals("Resources for learning", dto.getDescription());
    }

    @Test
    public void testAllArgsConstructor() {
        CategoryDTO dto = new CategoryDTO(1L, "Education", "Resources for learning");

        assertEquals(1L, dto.getId());
        assertEquals("Education", dto.getName());
        assertEquals("Resources for learning", dto.getDescription());
    }
}
