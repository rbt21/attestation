package dto;

public class UserDTO {
    private Long id;
    private String username;
    private String email;
    // Пароль обычно не включается в DTO, если не предполагается, что он передаётся от клиента к серверу, например, при регистрации.
    private String password; // Используйте его осторожно, только если нужно.

    // Конструктор без аргументов
    public UserDTO() {
    }

    // Конструктор со всеми полями
    public UserDTO(Long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password; // Опять же, будьте осторожны с паролем.
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    // Установка пароля должна выполняться с особой осторожностью и включать шифрование.
    public void setPassword(String password) {
        this.password = password;
    }
}
