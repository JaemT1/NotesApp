package co.practicas.noteshexagonalarch.infraestructure.output.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "categories")
    @ToString.Exclude
    private Set<NoteEntity> notes;

    public CategoryEntity(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
