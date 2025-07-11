package co.practicas.noteshexagonalarch.application.service;

import co.practicas.noteshexagonalarch.domain.model.Note;
import co.practicas.noteshexagonalarch.domain.port.in.ListNotesByCategoryUseCase;
import co.practicas.noteshexagonalarch.domain.port.out.NoteRepositoryPort;
import co.practicas.noteshexagonalarch.dto.NoteDTO;
import co.practicas.noteshexagonalarch.infraestructure.config.mapper.NoteMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListNotesByCategoryService implements ListNotesByCategoryUseCase {

    private final NoteRepositoryPort noteRepositoryPort;
    private final NoteMapper noteMapper;

    public ListNotesByCategoryService(NoteRepositoryPort noteRepositoryPort, NoteMapper noteMapper) {
        this.noteRepositoryPort = noteRepositoryPort;
        this.noteMapper = noteMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<NoteDTO> getNotesByCategory(String categoryName) {
        List<Note> notes = noteRepositoryPort.getNotesByCategory(categoryName);
        return notes.stream()
                .map(noteMapper::toDTO)
                .collect(Collectors.toList());
    }
}
