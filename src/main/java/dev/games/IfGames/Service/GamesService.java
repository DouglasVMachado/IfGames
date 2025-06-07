package dev.games.IfGames.Service;

import dev.games.IfGames.DTO.GamesDTO;
import dev.games.IfGames.Entity.GamesModel;
import dev.games.IfGames.Mapper.GamesMapper;
import dev.games.IfGames.Repository.GamesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GamesService {

    private GamesRepository gamesRepository;
    private GamesMapper gamesMapper;

    public GamesService(GamesRepository gamesRepository, GamesMapper gamesMapper) {
        this.gamesRepository = gamesRepository;
        this.gamesMapper = gamesMapper;
    }

    public List<GamesModel> listAllGames(){
        return gamesRepository.findAll();
    }

    public GamesModel searchById(Long id){
        Optional<GamesModel> gameById = gamesRepository.findById(id);
        return gameById.orElse(null);
    }

    public GamesDTO insertGames(GamesDTO gamesDTO){
        GamesModel games = gamesMapper.map(gamesDTO);
        games = gamesRepository.save(games);
        return gamesMapper.map(games);
    }

    public void deleteGame(Long id){
        gamesRepository.deleteById(id);
    }

    public GamesModel updateGames(Long id, GamesModel games){
        if(gamesRepository.existsById(id)){
            games.setId(id);
            return gamesRepository.save(games);
        }
        return null;
    }

}
