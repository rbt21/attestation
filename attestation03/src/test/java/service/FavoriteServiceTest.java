package service;

import model.Favorite;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.FavoriteRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class FavoriteServiceTest {

    private final FavoriteRepository favoriteRepository = mock(FavoriteRepository.class);
    private FavoriteService favoriteService;

    @BeforeEach
    void setUp() {
        favoriteService = new FavoriteService(favoriteRepository);
    }

    @Test
    void getAllFavorites_ShouldReturnAllFavorites() {
        when(favoriteRepository.findAll()).thenReturn(List.of(new Favorite()));

        List<Favorite> favorites = favoriteService.getAllFavorites();

        assertThat(favorites).isNotNull();
        assertThat(favorites.size()).isGreaterThan(0);
        verify(favoriteRepository).findAll();
    }

    @Test
    void getFavoriteById_ShouldReturnFavoriteWhenExists() {
        Favorite favorite = new Favorite();
        when(favoriteRepository.findById(1L)).thenReturn(Optional.of(favorite));

        Optional<Favorite> foundFavorite = favoriteService.getFavoriteById(1L);

        assertThat(foundFavorite).isPresent();
        verify(favoriteRepository).findById(1L);
    }

    @Test
    void addFavorite_ShouldSaveFavorite() {
        Favorite favorite = new Favorite();
        when(favoriteRepository.save(any(Favorite.class))).thenReturn(favorite);

        Favorite savedFavorite = favoriteService.addFavorite(favorite);

        assertThat(savedFavorite).isNotNull();
        verify(favoriteRepository).save(favorite);
    }

    @Test
    void removeFavorite_ShouldThrowIfNotExists() {
        when(favoriteRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> favoriteService.removeFavorite(1L));

        assertThat(exception.getMessage()).contains("Favorite not found with id 1");
        verify(favoriteRepository).findById(1L);
    }

    @Test
    void removeFavorite_ShouldDeleteFavoriteWhenExists() {
        Favorite favorite = new Favorite();
        when(favoriteRepository.findById(1L)).thenReturn(Optional.of(favorite));

        favoriteService.removeFavorite(1L);

        verify(favoriteRepository).delete(favorite);
    }
}
