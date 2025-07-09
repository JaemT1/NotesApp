package co.practicas.noteshexagonalarch.infraestructure.config.mapper;

import co.practicas.noteshexagonalarch.domain.model.Category;
import co.practicas.noteshexagonalarch.infraestructure.output.persistence.entity.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category toDomain(CategoryEntity entity) {
        return new Category(entity.getId(), entity.getName());
    }

    public CategoryEntity toEntity(Category domain) {
        return CategoryEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .build();
    }
}

