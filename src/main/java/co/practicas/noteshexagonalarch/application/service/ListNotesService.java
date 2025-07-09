package co.practicas.noteshexagonalarch.application.service;

import co.practicas.noteshexagonalarch.domain.model.Note;
import co.practicas.noteshexagonalarch.domain.port.in.ListNotesUseCase;
import co.practicas.noteshexagonalarch.domain.port.out.NoteRepositoryPort;
import co.practicas.noteshexagonalarch.dto.NoteDTO;
import co.practicas.noteshexagonalarch.infraestructure.config.mapper.NoteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ListNotesService implements ListNotesUseCase {

    private final NoteRepositoryPort noteRepositoryPort;
    private final NoteMapper noteMapper;

    @Override
    public List<NoteDTO> listAll() {
        List<Note> notes = noteRepositoryPort.getAllNotes();
        return notes.stream()
                .map(noteMapper::toDTO)
                .collect(Collectors.toList());
    }
}
