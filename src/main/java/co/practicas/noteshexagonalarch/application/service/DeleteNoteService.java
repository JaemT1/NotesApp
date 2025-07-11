package co.practicas.noteshexagonalarch.application.service;

import co.practicas.noteshexagonalarch.domain.port.in.DeleteNoteUseCase;
import co.practicas.noteshexagonalarch.domain.port.out.NoteRepositoryPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteNoteService implements DeleteNoteUseCase {

    private final NoteRepositoryPort noteRepositoryPort;

    public DeleteNoteService(NoteRepositoryPort noteRepositoryPort) {
        this.noteRepositoryPort = noteRepositoryPort;
    }

    @Override
    @Transactional
    public void deleteNote(Long noteId) {
        noteRepositoryPort.deleteNote(noteId);
    }
}
