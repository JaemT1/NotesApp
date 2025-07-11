package co.practicas.noteshexagonalarch.infraestructure.input;

import co.practicas.noteshexagonalarch.domain.port.in.*;
import co.practicas.noteshexagonalarch.dto.CreateNoteRequest;
import co.practicas.noteshexagonalarch.dto.NoteDTO;
import co.practicas.noteshexagonalarch.dto.UpdateNoteRequest;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
public class NoteController {

    private final CreateNoteUseCase createNoteUseCase;
    private final GetNoteUseCase getNoteUseCase;
    private final UpdateNoteUseCase updateNoteUseCase;
    private final DeleteNoteUseCase deleteNoteUseCase;
    private final ListNotesUseCase listNotesUseCase;
    private final ListNotesByCategoryUseCase listNotesByCategoryUseCase;
    private final GetActiveNotesUseCase getActiveNotesUseCase;
    private final GetArchivedNotesUseCase archivedNotesUseCase;
    private final ArchiveNoteUseCase archiveNoteUseCase;

    @PostMapping
    @Operation(summary = "Creates notes with title, content, and optional categories")
    public ResponseEntity<NoteDTO> create(@RequestBody CreateNoteRequest request) {
        return ResponseEntity.ok(createNoteUseCase.create(request));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retrieves a note by its ID")
    public ResponseEntity<NoteDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(getNoteUseCase.getById(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Updates a note by its ID")
    public ResponseEntity<NoteDTO> update(@PathVariable Long id, @RequestBody UpdateNoteRequest request) {
        return ResponseEntity.ok(updateNoteUseCase.updateNote(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletes a note by its ID")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deleteNoteUseCase.deleteNote(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getNotesByCategory/{categoryName}")
    @Operation(summary = "Retrieves notes by category name")
    public ResponseEntity<List<NoteDTO>> getNotesByCategory(@PathVariable String categoryName) {
        return ResponseEntity.ok(listNotesByCategoryUseCase.getNotesByCategory(categoryName));
    }

    @GetMapping
    @Operation(summary = "Retrieves all notes (both active and archived)")
    public ResponseEntity<List<NoteDTO>> listAll() {
        return ResponseEntity.ok(listNotesUseCase.listAll());
    }

    @GetMapping("/active")
    @Operation(summary = "Retrieves all active notes")
    public ResponseEntity<List<NoteDTO>> listActiveNotes() {
        return ResponseEntity.ok(getActiveNotesUseCase.getActiveNotes());
    }

    @GetMapping("/archived")
    @Operation(summary = "Retrieves all archived notes")
    public ResponseEntity<List<NoteDTO>> listArchivedNotes() {
        return ResponseEntity.ok(archivedNotesUseCase.getArchivedNotes());
    }

    @PostMapping("/archive/{id}")
    @Operation(summary = "Toggles the archived status of a note by ID")
    public ResponseEntity<NoteDTO> toggleArchive(@PathVariable Long id) {
        return ResponseEntity.ok(archiveNoteUseCase.archiveNote(id));
    }
}
