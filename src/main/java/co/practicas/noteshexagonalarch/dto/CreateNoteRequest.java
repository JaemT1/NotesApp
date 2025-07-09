package co.practicas.noteshexagonalarch.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public record CreateNoteRequest(
        @NotBlank String title,
        String content,
        Set<String> categories
)
{}
