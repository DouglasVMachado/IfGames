package dev.games.IfGames.DTO;

import dev.games.IfGames.Entity.CategoryModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GamesDTO {


    private Long id;
    private int lançamento;
    private String name;
    private Long preco;
    private String imgUrl;
    private String dificuldade;
    private CategoryModel category;

}
