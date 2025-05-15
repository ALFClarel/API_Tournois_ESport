package com.crud.tournoi_project.Repository;


import com.crud.tournoi_project.Entity.SimpleElim;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "simpleElims")
public interface SimpleElimRepository extends CrudRepository<SimpleElim, Integer> {
}
