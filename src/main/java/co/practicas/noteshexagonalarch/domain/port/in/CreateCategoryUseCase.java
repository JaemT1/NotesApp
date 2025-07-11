package co.practicas.noteshexagonalarch.domain.port.in;

import co.practicas.noteshexagonalarch.dto.CategoryDTO;
import co.practicas.noteshexagonalarch.dto.CreateCategoryRequest;

public interface CreateCategoryUseCase {
    CategoryDTO createCategory(CreateCategoryRequest categoryRequest);
}
