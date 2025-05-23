package com.crud.tournoi_project.Controller;

import com.crud.tournoi_project.Entity.Game;
import com.crud.tournoi_project.Repository.GameRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class GameController {

    private final GameRepository gameRepository;

    @Autowired
    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    // Page d'affichage des jeux
    @GetMapping("/games")
    public String gamesPage(Model model) {
        model.addAttribute("games", gameRepository.findAll());
        return "games/index";
    }

    // Page d'ajout d'un jeu
    @GetMapping("/game/add")
    public String addGame(Model model) {
        model.addAttribute("game", new Game());
        return "games/add";
    }

    // Sauvegarde des modifications ou création de jeu
    @PostMapping("/game/save")
    @Transactional
    public String processRegister(@ModelAttribute("game") Game game) {
        if (game.getId() != null) {
            // Récupérer le jeu existant
            Game existingGame = gameRepository.findById(game.getId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jeu non trouvé"));

            // Mise à jour des champs
            existingGame.setTitle(game.getTitle());
            existingGame.setDescription(game.getDescription());

            // Sauvegarde
            gameRepository.save(existingGame);
        } else {
            // Nouveau jeu
            gameRepository.save(game);
        }

        // Rediriger vers la page des jeux après enregistrement
        return "redirect:/games";
    }

    // Suppression d'un jeu
    @GetMapping("/game/delete/{id}")
    @Transactional
    public String deleteGame(@PathVariable Long id) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jeu non trouvé"));
        gameRepository.delete(game);
        return "redirect:/games";
    }

    // Affichage d'un jeu pour modification
    @GetMapping("/game/{id}")
    public String seeGame(@PathVariable Long id, Model model) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jeu non trouvé"));
        model.addAttribute("game", game);
        return "games/edit";
    }
}
