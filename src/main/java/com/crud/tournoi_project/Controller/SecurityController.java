package com.crud.tournoi_project.Controller;

import com.crud.tournoi_project.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SecurityController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout,
            Model model) {

        if (error != null) {
            model.addAttribute("errorMessage", "Identifiant ou mot de passe invalide");
        }
        if (logout != null) {
            model.addAttribute("logoutMessage", "Vous êtes bien déconnecté");
        }

        return "login";  // résout templates/login.html
    }

}
