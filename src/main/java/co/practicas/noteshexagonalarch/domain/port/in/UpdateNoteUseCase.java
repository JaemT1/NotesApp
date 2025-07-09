package co.practicas.noteshexagonalarch.domain.port.in;

import co.practicas.noteshexagonalarch.dto.NoteDTO;
import co.practicas.noteshexagonalarch.dto.UpdateNoteRequest;

public interface UpdateNoteUseCase {
    NoteDTO updateNote(Long id, UpdateNoteRequest note);
}
