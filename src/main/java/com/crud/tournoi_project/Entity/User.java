package com.crud.tournoi_project.Entity;

import jakarta.persistence.*;

@Entity
@Table(name= "utilisateur")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
