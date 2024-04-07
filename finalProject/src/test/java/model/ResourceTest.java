package model;

import org.example.project.model.Category;
import org.example.project.model.Resource;
import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;

class ResourceTest {

    @Test
    void testResourceGettersAndSetters() {
        Category category = new Category(1L, "Education", "Resources for learning", false);
        Resource resource = new Resource();

        resource.setId(1L);
        resource.setTitle("Java Programming");
        resource.setDescription("Comprehensive Java course");
        resource.setType("Online Course");
        resource.setUrl("http://example.com/java");
        resource.setCategory(category);

        assertEquals(1L, resource.getId());
        assertEquals("Java Programming", resource.getTitle());
        assertEquals("Comprehensive Java course", resource.getDescription());
        assertEquals("Online Course", resource.getType());
        assertEquals("http://example.com/java", resource.getUrl());
        assertNotNull(resource.getCategory());
        assertEquals("Education", resource.getCategory().getName());
    }

    @Test
    void testResourceAllArgsConstructor() {
        Category category = new Category(1L, "Education", "Resources for learning", false);
        Resource resource = new Resource(1L, "Java Programming", "Comprehensive Java course", "Online Course", "http://example.com/java", category);

        assertEquals(1L, resource.getId());
        assertEquals("Java Programming", resource.getTitle());
        assertEquals("Comprehensive Java course", resource.getDescription());
        assertEquals("Online Course", resource.getType());
        assertEquals("http://example.com/java", resource.getUrl());
        assertNotNull(resource.getCategory());
        assertEquals(1L, resource.getCategory().getId());
    }
}
