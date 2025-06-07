package dev.games.IfGames.Service;

import dev.games.IfGames.Entity.GamesModel;
import dev.games.IfGames.Repository.GamesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GamesService {

    private GamesRepository gamesRepository;

    public GamesService(GamesRepository gamesRepository) {
        this.gamesRepository = gamesRepository;
    }

    public List<GamesModel> listAllGames(){
        return gamesRepository.findAll();
    }

    public GamesModel searchById(Long id){
        Optional<GamesModel> gameById = gamesRepository.findById(id);
        return gameById.orElse(null);
    }

    public GamesModel insertGames(GamesModel games){
        return gamesRepository.save(games);
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
