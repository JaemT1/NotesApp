package co.practicas.noteshexagonalarch.domain.port.in;

import co.practicas.noteshexagonalarch.dto.NoteDTO;

public interface GetNoteUseCase {
    NoteDTO getById(Long id);
}
