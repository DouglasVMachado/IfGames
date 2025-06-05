package dev.games.IfGames.Service;

import dev.games.IfGames.Entity.CategoryModel;
import dev.games.IfGames.Repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryModel> listAllCategory(){
        return categoryRepository.findAll();
    }

    public CategoryModel searchCategory(Long id){
        Optional<CategoryModel> categoryModel = categoryRepository.findById(id);
        return categoryModel.orElse(null);
    }

    public CategoryModel createCategory(CategoryModel category){
        return categoryRepository.save(category);
    }

}
