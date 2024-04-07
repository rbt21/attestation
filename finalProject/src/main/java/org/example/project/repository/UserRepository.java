package org.example.project.repository;

import org.example.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Методы для поиска пользователей, например, по имени пользователя или email
    User findByUsername(String username);
    User findByEmail(String email);
}
