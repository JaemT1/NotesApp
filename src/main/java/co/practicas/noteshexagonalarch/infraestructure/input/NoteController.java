package co.practicas.noteshexagonalarch.infraestructure.input;

import co.practicas.noteshexagonalarch.domain.port.in.*;
import co.practicas.noteshexagonalarch.dto.CreateNoteRequest;
import co.practicas.noteshexagonalarch.dto.NoteDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final CreateNoteUseCase createNoteUseCase;
//    private final GetNoteUseCase getNoteUseCase;
//    private final UpdateNoteUseCase updateNoteUseCase;
//    private final DeleteNoteUseCase deleteNoteUseCase;
    private final ListNotesUseCase listNotesUseCase;

        public NoteController(CreateNoteUseCase createNoteUseCase,
                          //GetNoteUseCase getNoteUseCase,
                          //UpdateNoteUseCase updateNoteUseCase,
                          //DeleteNoteUseCase deleteNoteUseCase,
                          ListNotesUseCase listNotesUseCase) {
        this.createNoteUseCase = createNoteUseCase;
//        this.getNoteUseCase = getNoteUseCase;
//        this.updateNoteUseCase = updateNoteUseCase;
//        this.deleteNoteUseCase = deleteNoteUseCase;
        this.listNotesUseCase = listNotesUseCase;
    }

    @PostMapping
    @Operation(summary = "Creates notes with title, content, and optional categories")
    public ResponseEntity<NoteDTO> create(@RequestBody CreateNoteRequest request) {
        return ResponseEntity.ok(createNoteUseCase.create(request));
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<NoteDTO> getById(@PathVariable Long id) {
//        return ResponseEntity.ok(getNoteUseCase.getById(id));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<NoteDTO> update(@PathVariable Long id, @RequestBody UpdateNoteRequest request) {
//        return ResponseEntity.ok(updateNoteUseCase.updateNote(id, request));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id) {
//        deleteNoteUseCase.deleteNote(id);
//        return ResponseEntity.noContent().build();
//    }

    @GetMapping
    @Operation(summary = "Retrieves all notes (both active and archived)")
    public ResponseEntity<List<NoteDTO>> listAll() {
        return ResponseEntity.ok(listNotesUseCase.listAll());
    }
}
