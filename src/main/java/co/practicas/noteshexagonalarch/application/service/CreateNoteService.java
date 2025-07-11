package co.practicas.noteshexagonalarch.application.service;

import co.practicas.noteshexagonalarch.domain.model.Note;
import co.practicas.noteshexagonalarch.domain.port.in.CreateNoteUseCase;
import co.practicas.noteshexagonalarch.domain.port.out.NoteRepositoryPort;
import co.practicas.noteshexagonalarch.dto.CreateNoteRequest;
import co.practicas.noteshexagonalarch.dto.NoteDTO;
import co.practicas.noteshexagonalarch.infraestructure.config.mapper.NoteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateNoteService implements CreateNoteUseCase {

    private final NoteRepositoryPort noteRepositoryPort;
    private final NoteMapper noteMapper;

    @Override
    @Transactional
    public NoteDTO create(CreateNoteRequest request) {
        Note note = noteMapper.toDomain(request);
        Note saved = noteRepositoryPort.createNote(note, request.categories());
        return noteMapper.toDTO(saved);
    }
}