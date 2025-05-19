package com.crud.tournoi_project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/users/homepage")
    public String homepage(){
        return "users/homepage";
    }
}
