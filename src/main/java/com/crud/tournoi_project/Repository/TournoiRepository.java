package com.crud.tournoi_project.Repository;

import com.crud.tournoi_project.Entity.Tournoi;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "tournois")
public interface TournoiRepository extends CrudRepository<Tournoi, Integer> {

}
