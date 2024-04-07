package model;

import org.example.project.model.Favorite;
import org.example.project.model.Resource;
import org.example.project.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class FavoriteTest {

    @Test
    void testFavoriteGettersAndSetters() {
        User user = new User();
        user.setId(1L);

        Resource resource = new Resource();
        resource.setId(1L);

        Favorite favorite = new Favorite();
        favorite.setId(1L);
        favorite.setUser(user);
        favorite.setResource(resource);

        assertEquals(1L, favorite.getId());
        assertNotNull(favorite.getUser());
        assertEquals(1L, favorite.getUser().getId());
        assertNotNull(favorite.getResource());
        assertEquals(1L, favorite.getResource().getId());
    }

    @Test
    void testFavoriteAllArgsConstructor() {
        User user = new User();
        user.setId(1L);

        Resource resource = new Resource();
        resource.setId(1L);

        Favorite favorite = new Favorite(1L, user, resource);

        assertEquals(1L, favorite.getId());
        assertNotNull(favorite.getUser());
        assertEquals(1L, favorite.getUser().getId());
        assertNotNull(favorite.getResource());
        assertEquals(1L, favorite.getResource().getId());
    }
}
