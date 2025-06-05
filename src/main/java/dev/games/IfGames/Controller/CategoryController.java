package dev.games.IfGames.Controller;

import dev.games.IfGames.Entity.CategoryModel;
import dev.games.IfGames.Service.CategoryService;
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
    public CategoryModel createCategory(@RequestBody CategoryModel category){
        return categoryService.createCategory(category);
    }

    @GetMapping("/search/{id}")
    public CategoryModel searchCategory(@PathVariable Long id){
        return categoryService.searchCategory(id);
    }

    @GetMapping("/list")
    public List<CategoryModel> listAllCategory(){
        return categoryService.listAllCategory();
    }

    @PutMapping("/update")
    public String updateCategory(){
        return "Atualizar um categoria";
    }

    @DeleteMapping("/delete")
    public String deleteCategory(){
        return "Deletar o categoria";
    }


}
