package dto;

import org.example.project.dto.FavoriteDTO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FavoriteDTOTest {

    @Test
    public void testGettersAndSetters() {
        FavoriteDTO dto = new FavoriteDTO();
        dto.setId(1L);
        dto.setUserId(2L);
        dto.setResourceId(3L);

        assertEquals(1L, dto.getId());
        assertEquals(2L, dto.getUserId());
        assertEquals(3L, dto.getResourceId());
    }

    @Test
    public void testAllArgsConstructor() {
        FavoriteDTO dto = new FavoriteDTO(1L, 2L, 3L);

        assertEquals(1L, dto.getId());
        assertEquals(2L, dto.getUserId());
        assertEquals(3L, dto.getResourceId());
    }
}
