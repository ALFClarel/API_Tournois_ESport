package com.crud.tournoi_project.Repository;

import com.crud.tournoi_project.Entity.RoundRobin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "roundRobins")
public interface RoundRobinRepository extends CrudRepository<RoundRobin, Integer> {
}
