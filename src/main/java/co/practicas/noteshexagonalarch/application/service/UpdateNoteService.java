package co.practicas.noteshexagonalarch.application.service;

import co.practicas.noteshexagonalarch.domain.model.Note;
import co.practicas.noteshexagonalarch.domain.port.in.UpdateNoteUseCase;
import co.practicas.noteshexagonalarch.domain.port.out.NoteRepositoryPort;
import co.practicas.noteshexagonalarch.dto.NoteDTO;
import co.practicas.noteshexagonalarch.dto.UpdateNoteRequest;
import co.practicas.noteshexagonalarch.infraestructure.config.mapper.NoteMapper;
import org.springframework.stereotype.Service;

@Service
public class UpdateNoteService implements UpdateNoteUseCase {

    private final NoteRepositoryPort noteRepositoryPort;
    private final NoteMapper noteMapper;

    public UpdateNoteService(NoteRepositoryPort noteRepositoryPort, NoteMapper noteMapper) {
        this.noteRepositoryPort = noteRepositoryPort;
        this.noteMapper = noteMapper;
    }

    @Override
    public NoteDTO updateNote(Long id, UpdateNoteRequest request) {
        Note note = noteMapper.toDomain(request);
        return noteMapper.toDTO(noteRepositoryPort.updateNote(id, note));
    }
}
