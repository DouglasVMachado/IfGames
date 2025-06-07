package dev.games.IfGames.Mapper;

import dev.games.IfGames.DTO.GamesDTO;
import dev.games.IfGames.Entity.GamesModel;
import org.springframework.stereotype.Component;

@Component
public class GamesMapper {

    public GamesModel map(GamesDTO gamesDTO){

        GamesModel gamesModel = new GamesModel();
        gamesModel.setId(gamesDTO.getId());
        gamesModel.setLançamento(gamesDTO.getLançamento());
        gamesModel.setName(gamesDTO.getName());
        gamesModel.setPreco(gamesDTO.getPreco());
        gamesModel.setImgUrl(gamesDTO.getImgUrl());
        gamesModel.setDificuldade(gamesDTO.getDificuldade());
        gamesModel.setCategory(gamesDTO.getCategory());

        return gamesModel;

    }

    public GamesDTO map(GamesModel gamesModel){

        GamesDTO gamesDTO = new GamesDTO();
        gamesDTO.setId(gamesModel.getId());
        gamesDTO.setLançamento(gamesModel.getLançamento());
        gamesDTO.setName(gamesModel.getName());
        gamesDTO.setPreco(gamesModel.getPreco());
        gamesDTO.setImgUrl(gamesModel.getImgUrl());
        gamesDTO.setDificuldade(gamesModel.getDificuldade());
        gamesDTO.setCategory(gamesModel.getCategory());

        return gamesDTO;

    }

}
