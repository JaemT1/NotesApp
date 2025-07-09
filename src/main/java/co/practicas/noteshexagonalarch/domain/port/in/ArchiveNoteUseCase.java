package co.practicas.noteshexagonalarch.domain.port.in;

import co.practicas.noteshexagonalarch.dto.NoteDTO;

public interface ArchiveNoteUseCase {
    NoteDTO archiveNote(Long id);
}
