package co.practicas.noteshexagonalarch.infraestructure.output.persistence.repository;

import co.practicas.noteshexagonalarch.infraestructure.output.persistence.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaCategoryRepository extends JpaRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findByName(String name);
}

