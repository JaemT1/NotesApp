package co.practicas.noteshexagonalarch.application.service;

import co.practicas.noteshexagonalarch.domain.model.Note;
import co.practicas.noteshexagonalarch.domain.port.in.GetNoteUseCase;
import co.practicas.noteshexagonalarch.domain.port.out.NoteRepositoryPort;
import co.practicas.noteshexagonalarch.dto.NoteDTO;
import co.practicas.noteshexagonalarch.infraestructure.config.mapper.NoteMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GetNoteService implements GetNoteUseCase {

    private final NoteRepositoryPort noteRepositoryPort;
    private final NoteMapper noteMapper;

    public GetNoteService(NoteRepositoryPort noteRepositoryPort, NoteMapper noteMapper) {
        this.noteRepositoryPort = noteRepositoryPort;
        this.noteMapper = noteMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public NoteDTO getById(Long id) {
        Note note = noteRepositoryPort.getById(id).orElseThrow(() -> new IllegalArgumentException("Note not found with id: " + id));
        return noteMapper.toDTO(note);
    }

}
