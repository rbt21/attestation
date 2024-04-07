package repository;

import model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Методы для поиска категорий, если они вам нужны, например, по имени
    Category findByName(String name);

    List<Category> findAllByDeletedFalse();
}
