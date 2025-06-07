package dev.games.IfGames.Service;

import dev.games.IfGames.DTO.CategoryDTO;
import dev.games.IfGames.Entity.CategoryModel;
import dev.games.IfGames.Mapper.CategoryMapper;
import dev.games.IfGames.Repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;
    private CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public List<CategoryModel> listAllCategory(){
        return categoryRepository.findAll();
    }

    public CategoryModel searchCategory(Long id){
        Optional<CategoryModel> categoryModel = categoryRepository.findById(id);
        return categoryModel.orElse(null);
    }

    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        CategoryModel category = categoryMapper.map(categoryDTO);
        category = categoryRepository.save(category);
        return categoryMapper.map(category);
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }

    public CategoryModel updateCategory(Long id, CategoryModel category){
        if(categoryRepository.existsById(id)){
            category.setId(id);
            return categoryRepository.save(category);
        }
        return null;
    }

}
