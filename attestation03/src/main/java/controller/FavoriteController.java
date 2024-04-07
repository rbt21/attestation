package controller;

import model.Favorite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.FavoriteService;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {

    private final FavoriteService favoriteService;

    @Autowired
    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @GetMapping
    public ResponseEntity<List<Favorite>> getAllFavorites() {
        return ResponseEntity.ok(favoriteService.getAllFavorites());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Favorite> getFavoriteById(@PathVariable Long id) {
        return favoriteService.getFavoriteById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Favorite> addFavorite(@RequestBody Favorite favorite) {
        return ResponseEntity.ok(favoriteService.addFavorite(favorite));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeFavorite(@PathVariable Long id) {
        favoriteService.removeFavorite(id);
        return ResponseEntity.ok().build();
    }
}
