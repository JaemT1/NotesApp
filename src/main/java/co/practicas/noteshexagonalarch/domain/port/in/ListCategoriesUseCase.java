package co.practicas.noteshexagonalarch.domain.port.in;

import co.practicas.noteshexagonalarch.dto.CategoryDTO;

import java.util.List;

public interface ListCategoriesUseCase {
    List<CategoryDTO> listAllCategories();
}
