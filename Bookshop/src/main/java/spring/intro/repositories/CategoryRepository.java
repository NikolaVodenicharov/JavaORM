package spring.intro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.intro.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
