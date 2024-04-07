package org.example.project.dto;

public class ResourceDTO {
    private Long id;
    private String title;
    private String description;
    private String type;
    private String url;
    private Long categoryId; // Принадлежность к категории по ID

    // Конструктор без аргументов
    public ResourceDTO() {
    }

    // Конструктор со всеми полями
    public ResourceDTO(Long id, String title, String description, String type, String url, Long categoryId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.type = type;
        this.url = url;
        this.categoryId = categoryId;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
