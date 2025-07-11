package co.practicas.noteshexagonalarch.infraestructure.config.mapper;

import co.practicas.noteshexagonalarch.domain.model.Category;
import co.practicas.noteshexagonalarch.domain.model.Note;
import co.practicas.noteshexagonalarch.dto.CategoryDTO;
import co.practicas.noteshexagonalarch.dto.CreateCategoryRequest;
import co.practicas.noteshexagonalarch.dto.CreateNoteRequest;
import co.practicas.noteshexagonalarch.infraestructure.output.persistence.entity.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category entityToDomain(CategoryEntity entity) {
        return new Category(entity.getId(), entity.getName());
    }

    public CategoryEntity toEntity(Category domain) {
        return CategoryEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .build();
    }

    // Request -> Domain (crear)
    public Category requestToDomain(CreateCategoryRequest request) {
        return Category.builder()
                .name(request.name())
                .build();
    }

    public Category toDomain(CategoryEntity entity) {
        return new Category(entity.getId(), entity.getName());
    }

    public CategoryDTO toDTO(Category domain) {
        return new CategoryDTO(domain.getId(), domain.getName());
    }

    public Category dtoToDomain(CategoryDTO dto) {
        return new Category(dto.id(), dto.name());
    }

    public CategoryEntity toEntity(CategoryDTO dto) {
        return CategoryEntity.builder()
                .id(dto.id())
                .name(dto.name())
                .build();
    }


}

