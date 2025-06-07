package dev.games.IfGames.Mapper;

import dev.games.IfGames.DTO.CategoryDTO;
import dev.games.IfGames.Entity.CategoryModel;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public CategoryModel map(CategoryDTO categoryDTO){

        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setId(categoryDTO.getId());
        categoryModel.setCategory(categoryDTO.getCategory());
        categoryModel.setGames(categoryDTO.getGames());

        return categoryModel;

    }

    public CategoryDTO map(CategoryModel categoryModel){

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(categoryModel.getId());
        categoryDTO.setCategory(categoryModel.getCategory());
        categoryDTO.setGames(categoryModel.getGames());

        return categoryDTO;

    }

}
