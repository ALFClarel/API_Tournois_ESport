package com.crud.tournoi_project.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RoundRobin extends Tournoi{
    public Boolean getMatchRetour() {
        return isMatchRetour;
    }

    public void setMatchRetour(Boolean matchRetour) {
        isMatchRetour = matchRetour;
    }

    private Boolean isMatchRetour;

}
