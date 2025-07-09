package co.practicas.noteshexagonalarch.domain.port.out;

import co.practicas.noteshexagonalarch.domain.model.Note;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface NoteRepositoryPort {
    Note createNote(Note note, Set<String> categoryNames);
    Note updateNote(Long id, Note note);
    void deleteNote(Long id);
    Note toggleArchive(Long id);
    List<Note> getActiveNotes();
    List<Note> getArchivedNotes();
    Optional<Note> getById(Long id);
    List<Note> getNotesByCategory(String categoryName);
    List<Note> getAllNotes();
}
