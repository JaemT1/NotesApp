package co.practicas.noteshexagonalarch.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
@AllArgsConstructor
public class Category {
    private Long id;
    private String name;
}
