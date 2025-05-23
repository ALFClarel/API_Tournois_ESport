package com.crud.tournoi_project.Controller;

import com.crud.tournoi_project.Entity.Tournament;
import com.crud.tournoi_project.Entity.RoundRobin;
import com.crud.tournoi_project.Entity.SimpleElim;
import com.crud.tournoi_project.Entity.DoubleElim;
import com.crud.tournoi_project.Repository.TournamentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TournamentController {

    private final TournamentRepository tournamentRepository;

    public TournamentController(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    @GetMapping("/tournaments")
    public String tournaments(Model model) {
        model.addAttribute("tournaments", tournamentRepository.findAll());
        return "tournaments/index";
    }

    @GetMapping("/tournament/add")
    public String addTournament(Model model) {
        model.addAttribute("tournament", new Tournament());
        return "tournaments/add";
    }

    @PostMapping("/tournament/save")
    @Transactional
    public String processRegister(@RequestParam("tournamentClass") String tournamentClass, @ModelAttribute("tournament") Tournament tournament) {
        // Créer le tournoi selon le type spécifié
        if ("RoundRobin".equals(tournamentClass)) {
            tournament = new RoundRobin(); // Créer un tournoi RoundRobin
        } else if ("SimpleElim".equals(tournamentClass)) {
            tournament = new SimpleElim(); // Créer un tournoi SimpleElim
        } else if ("DoubleElim".equals(tournamentClass)) {
            tournament = new DoubleElim(); // Créer un tournoi DoubleElim
        }

        // Sauvegarder le tournoi avec le type spécifique
        tournamentRepository.save(tournament);

        // Redirection vers la liste des tournois
        return "redirect:/tournaments";
    }

    @GetMapping("/tournament/delete/{id}")
    @Transactional
    public String deleteTournament(@PathVariable("id") int id) {
        tournamentRepository.deleteById((long) id);
        return "redirect:/tournaments";
    }
}
