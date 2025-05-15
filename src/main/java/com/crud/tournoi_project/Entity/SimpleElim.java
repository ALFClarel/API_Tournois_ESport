package com.crud.tournoi_project.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SimpleElim extends Tournoi{
    public Boolean getTroisiemePlace() {
        return isTroisiemePlace;
    }

    public void setTroisiemePlace(Boolean troisiemePlace) {
        isTroisiemePlace = troisiemePlace;
    }

    private Boolean isTroisiemePlace;

}
