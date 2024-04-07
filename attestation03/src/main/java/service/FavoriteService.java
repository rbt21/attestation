package service;

import model.Favorite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.FavoriteRepository;
import java.util.List;
import java.util.Optional;

@Service
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;

    @Autowired
    public FavoriteService(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }

    public List<Favorite> getAllFavorites() {
        return favoriteRepository.findAll();
    }

    public Optional<Favorite> getFavoriteById(Long id) {
        return favoriteRepository.findById(id);
    }

    public Favorite addFavorite(Favorite favorite) {
        // Здесь может быть логика для предотвращения дублирования
        return favoriteRepository.save(favorite);
    }

    public void removeFavorite(Long id) {
        Favorite favorite = favoriteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Favorite not found with id " + id));
        favoriteRepository.delete(favorite);
    }

    // Дополнительные методы
}
