package dev.games.IfGames.Controller;

import dev.games.IfGames.DTO.GamesDTO;
import dev.games.IfGames.Entity.GamesModel;
import dev.games.IfGames.Service.GamesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> searchById(@PathVariable Long id){
        GamesDTO game = gamesService.searchById(id);
        if (game != null){
            return ResponseEntity.ok(game);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Game com o id " + id + " não encontrado!!");
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<GamesDTO>> listAllGames(){
        List<GamesDTO> gamesDTO = gamesService.listAllGames();
        return ResponseEntity.ok(gamesDTO);
    }

    @PostMapping("/create")
    public ResponseEntity<String> insertGame(@RequestBody GamesDTO games){
        GamesDTO gamesDTO = gamesService.insertGames(games);
        return ResponseEntity.status(HttpStatus.CREATED).body("Game inserido com sucesso, Nome do jogo inserido: " + gamesDTO.getName());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateGame(@PathVariable Long id, @RequestBody GamesDTO games){
        if(gamesService.searchById(id) != null){
            gamesService.updateGames(id, games);
            return ResponseEntity.ok().body("Game com o nome: " + games.getName() + " atualizado com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Game não existe, insira um id invalido");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> DeleteGame(@PathVariable Long id){
        if (gamesService.searchById(id) != null){
            gamesService.deleteGame(id);
            return ResponseEntity.ok("Game com o id: " + id + " Deletado com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id inserido não consta na lista, por favor insira um id valido!!");
        }
    }

}
