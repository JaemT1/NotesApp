package co.practicas.noteshexagonalarch.infraestructure.output.persistence.repository;

import co.practicas.noteshexagonalarch.infraestructure.output.persistence.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaNoteRepository extends JpaRepository<NoteEntity, Long> {
    List<NoteEntity> findByArchived(boolean archived);
    List<NoteEntity> findAllByCategories_Name(String name);
}
