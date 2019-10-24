package spring.exercise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.exercise.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
