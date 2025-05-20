package com.crud.tournoi_project.Repository;

import com.crud.tournoi_project.Entity.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {

}
