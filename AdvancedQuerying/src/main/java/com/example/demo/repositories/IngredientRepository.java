package com.example.demo.repositories;

import com.example.demo.domain.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findAllByNameStartingWith(String letters);

    List<Ingredient> findAllByNameIn(Collection<String> names);

    @Query("update ingredients as i set i.price = i.price * 1.2")
    @Modifying
    void updateAllPrice();

    @Query("update " +
            "ingredients as i " +
            "set i.price = i.price * 1.2 " +
            "where i.name in :ingredientNames")
    @Modifying
    void updatePriceByName(@Param("ingredientNames") Collection<String> ingredientNames);
}
