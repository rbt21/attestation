package repository;

import model.Category;
import model.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class ResourceRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;


    @BeforeEach
    public void setUp() {
        // Создаем и сохраняем тестовые объекты в базе данных
        Category category = entityManager.persist(new Category(null, "Education", "Resources for learning", false));
        entityManager.persist(new Resource(null, "Java Basics", "A book for beginners", "Book", "http://example.com/java-basics", category));
        entityManager.persist(new Resource(null, "Spring Framework", "A guide for intermediate learners", "Book", "http://example.com/spring-framework", category));
    }
}
