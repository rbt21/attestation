package service;

import model.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CategoryServiceTest {

    private final CategoryRepository categoryRepository = mock(CategoryRepository.class);
    private CategoryService categoryService;

    @BeforeEach
    void setUp() {
        categoryService = new CategoryService(categoryRepository);
    }

    @Test
    void getAllCategories_ShouldReturnNonDeletedCategories() {
        when(categoryRepository.findAllByDeletedFalse()).thenReturn(List.of(
                new Category(1L, "Education", "Resources for learning", false)
        ));

        List<Category> categories = categoryService.getAllCategories();

        assertThat(categories).hasSize(1);
        assertThat(categories.getFirst().getName()).isEqualTo("Education");
        verify(categoryRepository).findAllByDeletedFalse();
    }

    @Test
    void getCategoryById_ShouldReturnCategoryIfNotDeleted() {
        Category category = new Category(1L, "Education", "Resources for learning", false);
        when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));

        Optional<Category> foundCategory = categoryService.getCategoryById(1L);

        assertThat(foundCategory).isPresent();
        assertThat(foundCategory.get().getId()).isEqualTo(1L);
        verify(categoryRepository).findById(1L);
    }

    @Test
    void createCategory_ShouldSaveCategory() {
        Category category = new Category(null, "Education", "Resources for learning", false);
        when(categoryRepository.save(any(Category.class))).thenReturn(category);

        Category savedCategory = categoryService.createCategory(category);

        assertThat(savedCategory).isNotNull();
        verify(categoryRepository).save(category);
    }

    @Test
    void updateCategory_ShouldUpdateExistingCategory() {
        Category existingCategory = new Category(1L, "Education", "Resources for learning", false);
        when(categoryRepository.findById(1L)).thenReturn(Optional.of(existingCategory));
        when(categoryRepository.save(any(Category.class))).thenReturn(existingCategory);

        Category updatedCategory = new Category(1L, "New Name", "New Description", false);
        Category savedCategory = categoryService.updateCategory(1L, updatedCategory);

        assertThat(savedCategory.getName()).isEqualTo("New Name");
        assertThat(savedCategory.getDescription()).isEqualTo("New Description");
        verify(categoryRepository).save(existingCategory);
    }

    @Test
    void deleteCategory_ShouldSetDeletedFlag() {
        Category category = new Category(1L, "Education", "Resources for learning", false);
        when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));
        doAnswer(invocation -> {
            Category c = invocation.getArgument(0);
            assertThat(c.getDeleted()).isTrue();
            return null;
        }).when(categoryRepository).save(any(Category.class));

        categoryService.deleteCategory(1L);

        verify(categoryRepository).save(category);
        assertThat(category.getDeleted()).isTrue();
    }
}
