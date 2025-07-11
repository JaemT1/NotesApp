package co.practicas.noteshexagonalarch.infraestructure.output.persistence.adapter;

import co.practicas.noteshexagonalarch.domain.model.Category;
import co.practicas.noteshexagonalarch.domain.port.out.CategoryRepositoryPort;
import co.practicas.noteshexagonalarch.infraestructure.config.mapper.CategoryMapper;
import co.practicas.noteshexagonalarch.infraestructure.output.persistence.entity.CategoryEntity;
import co.practicas.noteshexagonalarch.infraestructure.output.persistence.repository.JpaCategoryRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryRepositoryAdapter implements CategoryRepositoryPort {
    private final JpaCategoryRepository jpaCategoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryRepositoryAdapter(JpaCategoryRepository jpaCategoryRepository, CategoryMapper categoryMapper) {
        this.jpaCategoryRepository = jpaCategoryRepository;
        this.categoryMapper = categoryMapper;
    }

    //Listar categorias
    public List<Category> getAllCategories() {
        List<CategoryEntity> categoryEntities = jpaCategoryRepository.findAll();
        return categoryEntities.stream()
                .map(categoryMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Category createCategory(Category category) {
        CategoryEntity categoryEntity = categoryMapper.toEntity(category);
        CategoryEntity savedCategoryEntity = jpaCategoryRepository.save(categoryEntity);
        return categoryMapper.toDomain(savedCategoryEntity);
    }
}
