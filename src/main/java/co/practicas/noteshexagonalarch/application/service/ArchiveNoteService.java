package co.practicas.noteshexagonalarch.application.service;

import co.practicas.noteshexagonalarch.domain.port.in.ArchiveNoteUseCase;
import co.practicas.noteshexagonalarch.domain.port.out.NoteRepositoryPort;
import co.practicas.noteshexagonalarch.dto.NoteDTO;
import co.practicas.noteshexagonalarch.infraestructure.config.mapper.NoteMapper;
import org.springframework.stereotype.Service;

@Service
public class ArchiveNoteService implements ArchiveNoteUseCase {

    private final NoteRepositoryPort noteRepositoryPort;
    private final NoteMapper noteMapper;

    public ArchiveNoteService(NoteRepositoryPort noteRepositoryPort,
                              NoteMapper noteMapper) {
        this.noteRepositoryPort = noteRepositoryPort;
        this.noteMapper = noteMapper;
    }

    @Override
    public NoteDTO archiveNote(Long id) {
        return noteMapper.toDTO(noteRepositoryPort.toggleArchive(id));
    }
}
