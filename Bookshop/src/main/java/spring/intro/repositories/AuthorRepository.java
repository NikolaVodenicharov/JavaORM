package spring.intro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.intro.entities.Author;
import spring.intro.entities.Book;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    List<Author> getAllByFirstNameEndingWith(String letters);

    @Query("select a, sum(b.copies) " +
            "from Author as a " +
            "join a.books as b " +
            "group by a " +
            "order by sum(b.copies) desc ")
    List<Author> getAllByBookCopies();
}
