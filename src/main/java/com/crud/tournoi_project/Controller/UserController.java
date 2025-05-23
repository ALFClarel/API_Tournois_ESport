package com.crud.tournoi_project.Controller;

import com.crud.tournoi_project.Entity.Game;
import com.crud.tournoi_project.Entity.Tournament;
import com.crud.tournoi_project.Entity.User;
import com.crud.tournoi_project.Repository.GameRepository;
import com.crud.tournoi_project.Repository.TournamentRepository;
import com.crud.tournoi_project.Repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private final TournamentRepository tournamentRepository;
    private final UserRepository userRepository;
    private final GameRepository gameRepository;

    public UserController(TournamentRepository tournamentRepository, UserRepository userRepository, GameRepository gameRepository) {
        this.tournamentRepository = tournamentRepository;
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
    }

    @GetMapping("/users/homepage")
    public String homepage(Model model) {
        List<Tournament> tournaments = tournamentRepository.findAll();
        Iterable<Game>  games = gameRepository.findAll();

        // Counter
        long countRoundRobin = tournamentRepository.countByTournamentClass("RoundRobin");
        long countSimpleElim = tournamentRepository.countByTournamentClass("SimpleElim");
        long countDoubleElim = tournamentRepository.countByTournamentClass("DoubleElim");
        long countTournament = tournamentRepository.count();
        long countGame = gameRepository.count();
        long countUser = userRepository.count();

        // Ajouter ces données au modèle
        model.addAttribute("countRoundRobin", countRoundRobin);
        model.addAttribute("countSimpleElim", countSimpleElim);
        model.addAttribute("countDoubleElim", countDoubleElim);
        model.addAttribute("countTournament", countTournament);
        model.addAttribute("countGame", countGame);
        model.addAttribute("countUser", countUser);

        // Passer chaque tournoi et son type à la vue
        for (Tournament tournament : tournaments) {
            tournament.setTournamentClass(tournament.getClass().getSimpleName());
        }

        // Sauvegarde tous les tournois en une seule fois
        tournamentRepository.saveAll(tournaments);

        model.addAttribute("tournaments", tournaments);
        return "users/homepage";
    }

}
