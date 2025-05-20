package com.crud.tournoi_project.Entity;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("DOUBLE")
public class DoubleElim extends Tournament{
    private Boolean isFinale;

    public Boolean getFinale() {
        return isFinale;
    }

    public void setFinale(Boolean finale) {
        isFinale = finale;
    }
}
