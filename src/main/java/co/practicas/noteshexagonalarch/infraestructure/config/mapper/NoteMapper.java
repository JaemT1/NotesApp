package co.practicas.noteshexagonalarch.infraestructure.config.mapper;

import co.practicas.noteshexagonalarch.domain.model.Category;
import co.practicas.noteshexagonalarch.domain.model.Note;
import co.practicas.noteshexagonalarch.infraestructure.output.persistence.entity.NoteEntity;
import co.practicas.noteshexagonalarch.dto.NoteDTO;
import co.practicas.noteshexagonalarch.dto.CreateNoteRequest;
import co.practicas.noteshexagonalarch.dto.UpdateNoteRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class NoteMapper {

    private final CategoryMapper categoryMapper;


    // DTO -> Domain
    public Note toDomain(NoteDTO dto) {
        return Note.builder()
                .id(dto.id())
                .title(dto.title())
                .content(dto.content())
                .archived(dto.archived())
                // Asignar categorías solo si es necesario
                .build();
    }

    // Domain -> DTO
    public NoteDTO toDTO(Note note) {
        Set<String> categoryNames = note.getCategories() != null
                ? note.getCategories().stream()
                .map(Category::getName)
                .collect(Collectors.toSet())
                : Collections.emptySet();

        return new NoteDTO(
                note.getId(),
                note.getTitle(),
                note.getContent(),
                note.isArchived(),
                categoryNames
        );
    }

    // Domain -> Entity
    public NoteEntity toEntity(Note note) {
        return NoteEntity.builder()
                .id(note.getId())
                .title(note.getTitle())
                .content(note.getContent())
                .archived(note.isArchived())
                .build();
    }

    // Entity -> Domain
    public Note toDomain(NoteEntity entity) {
        return Note.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .archived(entity.isArchived())
                .categories(
                        entity.getCategories() != null
                                ? entity.getCategories().stream()
                                .map(categoryMapper::toDomain)
                                .collect(Collectors.toSet())
                                : Set.of()
                )
                .build();
    }

    // Request -> Domain (crear)
    public Note toDomain(CreateNoteRequest request) {
        return Note.builder()
                .title(request.title())
                .content(request.content())
                .archived(false)
                .build();
    }

    // Request -> Domain (actualizar)
    public Note toDomain(UpdateNoteRequest request) {
        return Note.builder()
                .id(request.id())
                .title(request.title())
                .content(request.content())
                .build();
    }
}
