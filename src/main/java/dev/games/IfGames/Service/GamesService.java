package dev.games.IfGames.Service;

import dev.games.IfGames.DTO.GamesDTO;
import dev.games.IfGames.Entity.GamesModel;
import dev.games.IfGames.Mapper.GamesMapper;
import dev.games.IfGames.Repository.GamesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GamesService {

    private GamesRepository gamesRepository;
    private GamesMapper gamesMapper;

    public GamesService(GamesRepository gamesRepository, GamesMapper gamesMapper) {
        this.gamesRepository = gamesRepository;
        this.gamesMapper = gamesMapper;
    }

    public List<GamesDTO> listAllGames(){
        List<GamesModel> games = gamesRepository.findAll();
        return games.stream().map(gamesMapper::map).collect(Collectors.toList());
    }

    public GamesDTO searchById(Long id){
        Optional<GamesModel> gameById = gamesRepository.findById(id);
        return gameById.map(gamesMapper::map).orElse(null);
    }

    public GamesDTO insertGames(GamesDTO gamesDTO){
        GamesModel games = gamesMapper.map(gamesDTO);
        games = gamesRepository.save(games);
        return gamesMapper.map(games);
    }

    public void deleteGame(Long id){
        gamesRepository.deleteById(id);
    }

    public GamesDTO updateGames(Long id, GamesDTO gamesDTO){
        Optional<GamesModel> gamesModel = gamesRepository.findById(id);
        if (gamesModel.isPresent()){
            GamesModel gameAtualizado = gamesMapper.map(gamesDTO);
            gameAtualizado.setId(id);
            GamesModel gameSalvo = gamesRepository.save(gameAtualizado);
            return gamesMapper.map(gameSalvo);
        }
        return null;
    }

}
