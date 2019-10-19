package com.example.demo.repositories;

import com.example.demo.domain.entities.Ingredient;
import com.example.demo.domain.entities.Shampoo;
import com.example.demo.domain.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {
    List<Shampoo> findAllBySizeOrderById(Size size);

    List<Shampoo> findAllBySizeOrLabel_IdOrderByPrice(Size size, long id);

    List<Shampoo> findAllByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    int countByPriceLessThan(BigDecimal price);

    @Query("select i.shampoos " +
            "from ingredients as i " +
            "where i in :selectedIngredients")
    List<Shampoo> findAllByIngredients(@Param("selectedIngredients") Collection<Ingredient> selectedIngredients);

    @Query("select s " +
            "from shampoos as s " +
            "inner join s.ingredients as i " +
            "GROUP BY s.id " +
            "having  count(i.id) < :ingredientsCount")
    List<Shampoo> allByIngredientsCountLessThan(@Param("ingredientsCount") long ingredientsCount);

    @Query("select s " +
            "from shampoos as s " +
            "inner join s.ingredients as i " +
            "GROUP BY s " +
            "having sum(i.price) < :price")
    List<Shampoo> allByIngredientsPriceLessThan(@Param("price") BigDecimal price);



}
