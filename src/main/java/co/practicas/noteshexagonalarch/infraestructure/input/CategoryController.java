package co.practicas.noteshexagonalarch.infraestructure.input;

import co.practicas.noteshexagonalarch.domain.port.in.CreateCategoryUseCase;
import co.practicas.noteshexagonalarch.domain.port.in.ListCategoriesUseCase;
import co.practicas.noteshexagonalarch.dto.CategoryDTO;
import co.practicas.noteshexagonalarch.dto.CreateCategoryRequest;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final ListCategoriesUseCase listCategoriesUseCase;
    private final CreateCategoryUseCase createCategoryUseCase;

    public CategoryController(ListCategoriesUseCase listCategoriesUseCase, CreateCategoryUseCase createCategoryUseCase) {
        this.listCategoriesUseCase = listCategoriesUseCase;
        this.createCategoryUseCase = createCategoryUseCase;
    }

    @GetMapping
    @Operation(summary = "Retrieves all categories")
    public ResponseEntity<List<CategoryDTO>> listAll() {
        return ResponseEntity.ok(listCategoriesUseCase.listAllCategories());
    }

    @PostMapping
    @Operation(summary = "Creates a new category with the given name")
    public ResponseEntity<CategoryDTO> create(CreateCategoryRequest request) {
        CategoryDTO createdCategory = createCategoryUseCase.createCategory(request);
        return ResponseEntity.ok(createdCategory);
    }
}
