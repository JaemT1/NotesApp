package co.practicas.noteshexagonalarch.domain.port.out;

import co.practicas.noteshexagonalarch.domain.model.Category;
import co.practicas.noteshexagonalarch.domain.model.Note;

import java.util.List;

public interface CategoryRepositoryPort {
    List<Category> getAllCategories();
    Category createCategory(Category category);
}
