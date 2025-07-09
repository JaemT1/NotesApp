package co.practicas.noteshexagonalarch.infraestructure.output.persistence.adapter;

import co.practicas.noteshexagonalarch.domain.model.Note;
import co.practicas.noteshexagonalarch.domain.port.out.NoteRepositoryPort;
import co.practicas.noteshexagonalarch.infraestructure.config.mapper.NoteMapper;
import co.practicas.noteshexagonalarch.infraestructure.output.persistence.entity.CategoryEntity;
import co.practicas.noteshexagonalarch.infraestructure.output.persistence.entity.NoteEntity;
import co.practicas.noteshexagonalarch.infraestructure.output.persistence.repository.JpaCategoryRepository;
import co.practicas.noteshexagonalarch.infraestructure.output.persistence.repository.JpaNoteRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class NoteRepositoryAdapter implements NoteRepositoryPort {

    private final JpaNoteRepository jpaNoteRepository;
    private final JpaCategoryRepository jpaCategoryRepository;
    private final NoteMapper noteMapper;

    public NoteRepositoryAdapter(JpaNoteRepository jpaNoteRepository,
                                 JpaCategoryRepository jpaCategoryRepository,
                                 NoteMapper noteMapper) {
        this.jpaNoteRepository = jpaNoteRepository;
        this.jpaCategoryRepository = jpaCategoryRepository;
        this.noteMapper = noteMapper;
    }

    @Override
    public Note createNote(Note note, Set<String> categoryNames) {
        NoteEntity entity = noteMapper.toEntity(note);

        //Buscar o crear categorías por nombre
        Set<CategoryEntity> categories = categoryNames.stream()
                .map(name -> jpaCategoryRepository.findByName(name)
                        .orElseGet(() -> jpaCategoryRepository.save(
                                CategoryEntity.builder().name(name).build()
                        ))
                ).collect(Collectors.toSet());

        //Asignar categorías a la nota
        entity.setCategories(categories);

        //Guardar la nota (esto también guarda la relación many-to-many)
        NoteEntity saved = jpaNoteRepository.save(entity);

        return noteMapper.toDomain(saved);
    }

    @Override
    public Note updateNote(Long id, Note note) {
        return jpaNoteRepository.findById(id)
                .map(existingEntity -> {
                    existingEntity.setTitle(note.getTitle());
                    existingEntity.setContent(note.getContent());
                    existingEntity.setArchived(note.isArchived());
                    // Aquí puedes actualizar las categorías si es necesario
                    NoteEntity updatedEntity = jpaNoteRepository.save(existingEntity);
                    return noteMapper.toDomain(updatedEntity);
                })
                .orElseThrow(() -> new RuntimeException("Note not found with id: " + id));
    }

    @Override
    public Optional<Note> getById(Long id) {
        return jpaNoteRepository.findById(id)
                .map(noteMapper::toDomain);
    }

    @Override
    public List<Note> getNotesByCategory(String categoryName) {
        return jpaNoteRepository.findAllByCategories_Name(categoryName).stream()
                .map(noteMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Note> getAllNotes() {
        return jpaNoteRepository.findAll().stream()
                .map(noteMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteNote(Long id) {
        jpaNoteRepository.deleteById(id);
    }

    @Override
    public Note toggleArchive(Long id) {
        return jpaNoteRepository.findById(id)
                .map(noteEntity -> {
                    noteEntity.setArchived(!noteEntity.isArchived());
                    NoteEntity updatedEntity = jpaNoteRepository.save(noteEntity);
                    return noteMapper.toDomain(updatedEntity);
                })
                .orElseThrow(() -> new RuntimeException("Note not found with id: " + id));
    }

    @Override
    public List<Note> getActiveNotes() {
        return jpaNoteRepository.findByArchived(false).stream()
                .map(noteMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Note> getArchivedNotes() {
        return jpaNoteRepository.findByArchived(true).stream()
                .map(noteMapper::toDomain)
                .collect(Collectors.toList());
    }
}
