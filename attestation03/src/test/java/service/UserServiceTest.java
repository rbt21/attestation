package service;

import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.UserRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserServiceTest {

    private final UserRepository userRepository = mock(UserRepository.class);
    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService(userRepository);
    }

    @Test
    void getAllUsers_ShouldReturnAllUsers() {
        when(userRepository.findAll()).thenReturn(List.of(new User()));

        List<User> users = userService.getAllUsers();

        assertThat(users).isNotNull();
        assertThat(users.size()).isGreaterThan(0);
        verify(userRepository).findAll();
    }

    @Test
    void getUserById_ShouldReturnUserWhenExists() {
        User user = new User();
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        Optional<User> foundUser = userService.getUserById(1L);

        assertThat(foundUser).isPresent();
        verify(userRepository).findById(1L);
    }

    @Test
    void createUser_ShouldSaveUser() {
        User user = new User();
        when(userRepository.save(any(User.class))).thenReturn(user);

        User savedUser = userService.createUser(user);

        assertThat(savedUser).isNotNull();
        verify(userRepository).save(user);
    }

    @Test
    void updateUser_ShouldUpdateExistingUser() {
        User existingUser = new User();
        User userDetails = new User();
        userDetails.setUsername("NewUsername");
        userDetails.setEmail("newemail@example.com");

        when(userRepository.findById(1L)).thenReturn(Optional.of(existingUser));
        when(userRepository.save(any(User.class))).thenReturn(existingUser);

        User updatedUser = userService.updateUser(1L, userDetails);

        assertThat(updatedUser.getUsername()).isEqualTo("NewUsername");
        assertThat(updatedUser.getEmail()).isEqualTo("newemail@example.com");
        verify(userRepository).save(existingUser);
    }

    @Test
    void deleteUser_ShouldThrowIfNotExists() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> userService.deleteUser(1L));

        assertThat(exception.getMessage()).contains("User not found with id 1");
        verify(userRepository).findById(1L);
    }

    @Test
    void deleteUser_ShouldDeleteUserWhenExists() {
        User user = new User();
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        userService.deleteUser(1L);

        verify(userRepository).delete(user);
    }
}
