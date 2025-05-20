package com.crud.tournoi_project.Entity;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("SIMPLE")
public class SimpleElim extends Tournament{
    public Boolean getTroisiemePlace() {
        return isTroisiemePlace;
    }

    public void setTroisiemePlace(Boolean troisiemePlace) {
        isTroisiemePlace = troisiemePlace;
    }

    private Boolean isTroisiemePlace;

}
