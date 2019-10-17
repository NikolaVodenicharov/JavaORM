package spring.intro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.intro.entities.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
