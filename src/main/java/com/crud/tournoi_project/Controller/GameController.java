package com.crud.tournoi_project.Controller;

import com.crud.tournoi_project.Entity.Game;
import com.crud.tournoi_project.Repository.GameRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GameController {

    private final GameRepository gameRepository;

    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @GetMapping("/game/add")
    public String addGame(Model model) {
        model.addAttribute("game", new Game());
        return "games/add";
    }

    @PostMapping("/game/save")
    public String processRegister(@ModelAttribute("user") Game game) {
        gameRepository.save(game);

        return "redirect:/games";
    }
}
