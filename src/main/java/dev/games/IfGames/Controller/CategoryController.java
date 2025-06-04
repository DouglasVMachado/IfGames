package dev.games.IfGames.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @PostMapping("/create")
    public String createCategory(){
        return "criar categoria";
    }

    @GetMapping("/search")
    public String searchGame(){
        return "Procurar algum jogo";
    }

    @GetMapping("/list")
    public String listAllGames(){
        return "Listar todos os jogos";
    }

    @PutMapping("/update")
    public String updateGame(){
        return "Atualizar um jogo";
    }

    @DeleteMapping("/delete")
    public String deleteGame(){
        return "Deletar o jogo";
    }


}
