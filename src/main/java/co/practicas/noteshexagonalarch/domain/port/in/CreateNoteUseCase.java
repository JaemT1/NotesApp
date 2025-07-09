package co.practicas.noteshexagonalarch.domain.port.in;

import co.practicas.noteshexagonalarch.dto.CreateNoteRequest;
import co.practicas.noteshexagonalarch.dto.NoteDTO;

public interface CreateNoteUseCase {
    NoteDTO create(CreateNoteRequest request);
}
