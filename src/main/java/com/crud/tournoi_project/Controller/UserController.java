package com.crud.tournoi_project.Controller;

import com.crud.tournoi_project.Entity.Tournament;
import com.crud.tournoi_project.Repository.TournamentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {
    private final TournamentRepository tournamentRepository;

    public UserController(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    @GetMapping("/users/homepage")
    public String homepage(Model model) {
        List<Tournament> tournaments = tournamentRepository.findAll();

        // Counter
        long countRoundRobin = tournamentRepository.countByTournamentClass("RoundRobin");
        long countSimpleElim = tournamentRepository.countByTournamentClass("SimpleElim");
        long countDoubleElim = tournamentRepository.countByTournamentClass("DoubleElim");
        long countTournament = tournamentRepository.count();

        // Ajouter ces données au modèle
        model.addAttribute("countRoundRobin", countRoundRobin);
        model.addAttribute("countSimpleElim", countSimpleElim);
        model.addAttribute("countDoubleElim", countDoubleElim);
        model.addAttribute("countTournament", countTournament);

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
