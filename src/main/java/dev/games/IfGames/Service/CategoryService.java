package dev.games.IfGames.Service;

import dev.games.IfGames.DTO.CategoryDTO;
import dev.games.IfGames.Entity.CategoryModel;
import dev.games.IfGames.Mapper.CategoryMapper;
import dev.games.IfGames.Repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;
    private CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public List<CategoryDTO> listAllCategory(){
        List<CategoryModel> categoryModel = categoryRepository.findAll();
        return categoryModel.stream().map(categoryMapper::map).collect(Collectors.toList());
    }

    public CategoryDTO searchCategory(Long id){
        Optional<CategoryModel> categoryModel = categoryRepository.findById(id);
        return categoryModel.map(categoryMapper::map).orElse(null);
    }

    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        CategoryModel category = categoryMapper.map(categoryDTO);
        category = categoryRepository.save(category);
        return categoryMapper.map(category);
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }

    public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO){
        Optional<CategoryModel> categoryModel = categoryRepository.findById(id);
        if(categoryModel.isPresent()){
            CategoryModel categoryUpdate = categoryMapper.map(categoryDTO);
            categoryUpdate.setId(id);
            CategoryModel categorySave = categoryRepository.save(categoryUpdate);
            return categoryMapper.map(categorySave);
        }
        return null;
    }

}
