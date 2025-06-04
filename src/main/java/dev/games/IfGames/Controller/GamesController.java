package dev.games.IfGames.Controller;

import dev.games.IfGames.Entity.GamesModel;
import dev.games.IfGames.Service.GamesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GamesController {

    private GamesService gamesService;

    @GetMapping("/search")
    public String searchById(){
        return "buscando jogos por id";
    }

    @GetMapping("/list")
    public List<GamesModel> listAllGames(){
        return gamesService.listAllGames();
    }

    @PostMapping("/create")
    public String insertGame(){
        return "Inserir o jogo";
    }

    @PutMapping("/update")
    public String updateGame(){
        return "atualizar algum jogo";
    }

    @DeleteMapping("/Delete")
    public String DeleteGame(){
        return "Deletar um jogo";
    }

}
