package org.example.project.dto;

public class FavoriteDTO {
    private Long id;
    private Long userId;
    private Long resourceId;

    // Конструктор без аргументов
    public FavoriteDTO() {
    }

    // Конструктор со всеми полями
    public FavoriteDTO(Long id, Long userId, Long resourceId) {
        this.id = id;
        this.userId = userId;
        this.resourceId = resourceId;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }
}
