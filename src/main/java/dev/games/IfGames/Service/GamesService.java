package dev.games.IfGames.Service;

import dev.games.IfGames.Entity.GamesModel;
import dev.games.IfGames.Repository.GamesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GamesService {

    private GamesRepository gamesRepository;

    public GamesService(GamesRepository gamesRepository) {
        this.gamesRepository = gamesRepository;
    }

    public List<GamesModel> listAllGames(){
        return gamesRepository.findAll();
    }

}
