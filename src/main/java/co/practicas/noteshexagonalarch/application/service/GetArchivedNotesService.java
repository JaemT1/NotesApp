package co.practicas.noteshexagonalarch.application.service;

import co.practicas.noteshexagonalarch.domain.model.Note;
import co.practicas.noteshexagonalarch.domain.port.in.GetArchivedNotesUseCase;
import co.practicas.noteshexagonalarch.domain.port.out.NoteRepositoryPort;
import co.practicas.noteshexagonalarch.dto.NoteDTO;
import co.practicas.noteshexagonalarch.infraestructure.config.mapper.NoteMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetArchivedNotesService implements GetArchivedNotesUseCase {

    private final NoteRepositoryPort noteRepositoryPort;
    private final NoteMapper noteMapper;

    public GetArchivedNotesService(NoteRepositoryPort noteRepositoryPort, NoteMapper noteMapper) {
        this.noteRepositoryPort = noteRepositoryPort;
        this.noteMapper = noteMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<NoteDTO> getArchivedNotes() {
        List<Note> archivedNotes = noteRepositoryPort.getArchivedNotes();
        return archivedNotes.stream()
                .map(noteMapper::toDTO)
                .collect(Collectors.toList());
    }
}
