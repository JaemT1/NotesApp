package co.practicas.noteshexagonalarch.application.service;

import co.practicas.noteshexagonalarch.domain.model.Category;
import co.practicas.noteshexagonalarch.domain.port.in.ListCategoriesUseCase;
import co.practicas.noteshexagonalarch.domain.port.out.CategoryRepositoryPort;
import co.practicas.noteshexagonalarch.dto.CategoryDTO;
import co.practicas.noteshexagonalarch.infraestructure.config.mapper.CategoryMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListCategoriesService implements ListCategoriesUseCase {

    private final CategoryRepositoryPort categoryRepositoryPort;
    private final CategoryMapper categoryMapper;

    public ListCategoriesService(CategoryRepositoryPort categoryRepositoryPort, CategoryMapper categoryMapper) {
        this.categoryRepositoryPort = categoryRepositoryPort;
        this.categoryMapper = categoryMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryDTO> listAllCategories() {
        List<Category> categories = categoryRepositoryPort.getAllCategories();
        return categories.stream()
                .map(categoryMapper::toDTO)
                .collect(Collectors.toList());
    }

}
