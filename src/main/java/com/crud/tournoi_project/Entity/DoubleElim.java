package com.crud.tournoi_project.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DoubleElim extends Tournoi{
    private Boolean isFinale;

    public Boolean getFinale() {
        return isFinale;
    }

    public void setFinale(Boolean finale) {
        isFinale = finale;
    }
}
