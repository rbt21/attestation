package repository;

import model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {
    // Методы для поиска ресурсов, например, по типу или категории
    List<Resource> findByType(String type);
    List<Resource> findByCategoryId(Long categoryId);
}
