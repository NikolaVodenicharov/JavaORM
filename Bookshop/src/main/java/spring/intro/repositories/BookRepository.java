package spring.intro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.intro.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
