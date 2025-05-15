package com.crud.tournoi_project.Repository;

import com.crud.tournoi_project.Entity.DoubleElim;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "doubleElims")
public interface DoubleElimRepository extends CrudRepository<DoubleElim, Integer> {
}
