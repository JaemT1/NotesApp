package co.practicas.noteshexagonalarch.domain.port.in;

import co.practicas.noteshexagonalarch.dto.NoteDTO;

import java.util.List;

public interface ListNotesUseCase {
    List<NoteDTO> listAll();
}
