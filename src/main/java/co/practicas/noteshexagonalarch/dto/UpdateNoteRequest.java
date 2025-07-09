package co.practicas.noteshexagonalarch.dto;

import jakarta.validation.constraints.NotBlank;

public record UpdateNoteRequest(
        Long id,
        @NotBlank String title,
        String content
) {
}
