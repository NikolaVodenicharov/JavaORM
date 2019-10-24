package spring.exercise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.exercise.entities.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
}
