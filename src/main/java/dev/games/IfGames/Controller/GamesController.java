package dev.games.IfGames.Controller;

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
    public GamesModel searchById(@PathVariable Long id){
        return gamesService.searchById(id);
    }

    @GetMapping("/list")
    public List<GamesModel> listAllGames(){
        return gamesService.listAllGames();
    }

    @PostMapping("/create")
    public GamesModel insertGame(@RequestBody GamesModel games){
        return gamesService.insertGames(games);
    }

    @PutMapping("/update/{id}")
    public GamesModel updateGame(@PathVariable Long id, @RequestBody GamesModel games){
        return gamesService.updateGames(id, games);
    }

    @DeleteMapping("/delete/{id}")
    public void DeleteGame(@PathVariable Long id){
        gamesService.deleteGame(id);
    }

}
