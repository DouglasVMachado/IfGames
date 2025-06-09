package dev.games.IfGames.Controller;

import dev.games.IfGames.DTO.GamesDTO;
import dev.games.IfGames.Entity.GamesModel;
import dev.games.IfGames.Service.GamesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GamesController {

    private GamesService gamesService;

    public GamesController(GamesService gamesService) {
        this.gamesService = gamesService;
    }

    @GetMapping("/search/{id}")
    public GamesDTO searchById(@PathVariable Long id){
        return gamesService.searchById(id);
    }

    @GetMapping("/list")
    public List<GamesDTO> listAllGames(){
        return gamesService.listAllGames();
    }

    @PostMapping("/create")
    public GamesDTO insertGame(@RequestBody GamesDTO games){
        return gamesService.insertGames(games);
    }

    @PutMapping("/update/{id}")
    public GamesDTO updateGame(@PathVariable Long id, @RequestBody GamesDTO games){
        return gamesService.updateGames(id, games);
    }

    @DeleteMapping("/delete/{id}")
    public void DeleteGame(@PathVariable Long id){
        gamesService.deleteGame(id);
    }

}
