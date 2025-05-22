package com.crud.tournoi_project.Controller;

import com.crud.tournoi_project.Entity.Tournament;
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
    public String addtournament(Model model) {
        model.addAttribute("tournament", new Tournament());
        return "tournaments/add";
    }

    @PostMapping("/tournament/save")
    @Transactional
    public String processRegister(@ModelAttribute("tournament") Tournament tournament) {
        tournamentRepository.save(tournament);
        return "redirect:/tournaments";
    }

    @GetMapping("/tournament/delete/{id}")
    @Transactional
    public String deleteTournament(@PathVariable("id") int id) {
        tournamentRepository.deleteById((long) id);

        return "redirect:/tournaments";
    }
}
