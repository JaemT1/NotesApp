package co.practicas.noteshexagonalarch.application.service;

import co.practicas.noteshexagonalarch.domain.model.Category;
import co.practicas.noteshexagonalarch.domain.port.in.CreateCategoryUseCase;
import co.practicas.noteshexagonalarch.domain.port.out.CategoryRepositoryPort;
import co.practicas.noteshexagonalarch.dto.CategoryDTO;
import co.practicas.noteshexagonalarch.dto.CreateCategoryRequest;
import co.practicas.noteshexagonalarch.infraestructure.config.mapper.CategoryMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateCategoryService implements CreateCategoryUseCase {

    private final CategoryRepositoryPort categoryRepositoryPort;
    private final CategoryMapper categoryMapper;

    public CreateCategoryService(CategoryRepositoryPort categoryRepositoryPort, CategoryMapper categoryMapper) {
        this.categoryRepositoryPort = categoryRepositoryPort;
        this.categoryMapper = categoryMapper;
    }

    @Override
    @Transactional
    public CategoryDTO createCategory(CreateCategoryRequest categoryRequest) {
        Category category = categoryMapper.requestToDomain(categoryRequest);
        Category createdCategory = categoryRepositoryPort.createCategory(category);
        return categoryMapper.toDTO(createdCategory);
    }
}
