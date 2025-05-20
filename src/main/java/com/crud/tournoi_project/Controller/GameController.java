package com.crud.tournoi_project.Controller;

import com.crud.tournoi_project.Entity.Game;
import com.crud.tournoi_project.Repository.GameRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GameController {

    private final GameRepository gameRepository;

    @Autowired
    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @GetMapping("/games")
    public String gamesPage(Model model) {
        model.addAttribute("games", gameRepository.findAll());

        return "games/index";
    }

    @GetMapping("/game/add")
    public String addGame(Model model) {
        model.addAttribute("game", new Game());
        return "games/add";
    }

    @PostMapping("/game/save")
    @Transactional
    public String processRegister(@ModelAttribute("game") Game game) {
        gameRepository.save(game);
        return "redirect:/games";
    }

    @GetMapping("/game/details/{id}")
    @Transactional
    public String updateGame(@PathVariable Long id, @ModelAttribute("game") Game game) {
        gameRepository.findById(id);
        gameRepository.save(game);
        return "redirect:/games";
    }
}
