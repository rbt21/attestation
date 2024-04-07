package org.example.project.repository;

import java.util.List;
import org.example.project.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    // Методы для работы с избранными записями, например, поиск всех избранных для пользователя
    List<Favorite> findByUserId(Long userId);
    List<Favorite> findByResourceId(Long resourceId);
}
