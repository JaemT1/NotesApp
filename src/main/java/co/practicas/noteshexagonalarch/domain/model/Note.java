package co.practicas.noteshexagonalarch.domain.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Builder
@Data
public class Note {
    private Long id;
    private String title;
    private String content;
    private boolean archived = false;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Set<Category> categories;
}
