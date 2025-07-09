package co.practicas.noteshexagonalarch.dto;

import co.practicas.noteshexagonalarch.domain.model.Note;

import java.util.Set;

public record NoteDTO(
        Long id,
        String title,
        String content,
        boolean archived,
        Set<String> categories
)
{
    public Note toNote() {
        return Note.builder()
                .id(id)
                .title(title)
                .content(content)
                .archived(archived)
                .build();
    }
}
