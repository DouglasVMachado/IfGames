package dev.games.IfGames.Controller;

import dev.games.IfGames.DTO.CategoryDTO;
import dev.games.IfGames.Entity.CategoryModel;
import dev.games.IfGames.Service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createCategory(@RequestBody CategoryDTO category){
        CategoryDTO categoryDTO = categoryService.createCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body("Category criada com sucesso");
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> searchCategory(@PathVariable Long id){
        CategoryDTO categoryDTO = categoryService.searchCategory(id);
        if (categoryDTO != null){
            return ResponseEntity.ok(categoryDTO);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category não encontrada");
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<CategoryDTO>> listAllCategory(){
        List<CategoryDTO> category = categoryService.listAllCategory();
        return ResponseEntity.ok(category);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable Long id, @RequestBody CategoryDTO category){
        if (categoryService.searchCategory(id) != null){
            categoryService.updateCategory(id, category);
            return ResponseEntity.ok("Category atualizada com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado o id, insira um valido");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id){
        if (categoryService.searchCategory(id) != null){
            categoryService.deleteCategory(id);
            return ResponseEntity.ok("Category foi deletada com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado, insira um id valido");
        }
    }


}
