package model;

import org.example.project.model.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CategoryTest {

    @Test
    void testCategoryGettersAndSetters() {
        Category category = new Category();
        category.setId(1L);
        category.setName("Education");
        category.setDescription("Resources for learning");
        category.setDeleted(false);

        Assertions.assertEquals(1L, category.getId());
        Assertions.assertEquals("Education", category.getName());
        Assertions.assertEquals("Resources for learning", category.getDescription());
        Assertions.assertFalse(category.getDeleted());
    }

    @Test
    void testCategoryAllArgsConstructor() {
        Category category = new Category(1L, "Education", "Resources for learning", false);

        Assertions.assertEquals(1L, category.getId());
        Assertions.assertEquals("Education", category.getName());
        Assertions.assertEquals("Resources for learning", category.getDescription());
        Assertions.assertFalse(category.getDeleted());
    }
}
