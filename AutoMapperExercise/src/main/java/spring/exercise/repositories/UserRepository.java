package spring.exercise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.exercise.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
