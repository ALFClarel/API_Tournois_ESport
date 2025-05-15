package com.crud.tournoi_project.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tournoi")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Tournoi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private Date date_debut;
    private Date date_fin;

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public Long getId() {
        return id;
    }

}
