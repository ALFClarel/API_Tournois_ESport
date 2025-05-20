package com.crud.tournoi_project.Entity;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("ROUND")
public class RoundRobin extends Tournament{
    public Boolean getMatchRetour() {
        return isMatchRetour;
    }

    public void setMatchRetour(Boolean matchRetour) {
        isMatchRetour = matchRetour;
    }

    private Boolean isMatchRetour;

}
