package com.crud.tournoi_project.Repository;

import com.crud.tournoi_project.Entity.Tournament;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "tournois")
public interface TournamentRepository extends CrudRepository<Tournament, Integer> {

}
