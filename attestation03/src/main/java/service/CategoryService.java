package service;

import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CategoryRepository;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        // Изменено на использование метода, который возвращает только неудаленные категории
        return categoryRepository.findAllByDeletedFalse();
    }

    public Optional<Category> getCategoryById(Long id) {
        // Добавлена проверка, что категория не помечена как удаленная
        return categoryRepository.findById(id)
                .filter(category -> !category.getDeleted());
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long id, Category categoryDetails) {
        Category category = getCategoryById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id " + id));
        category.setName(categoryDetails.getName());
        category.setDescription(categoryDetails.getDescription());
        // Здесь нет необходимости менять логику, так как обновление уже работает с существующими записями
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        // Изменено на установку флага deleted в true вместо физического удаления
        Category category = getCategoryById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id " + id));
        category.setDeleted(true);
        categoryRepository.save(category);
    }
}