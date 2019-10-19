package com.example.demo.services;

import com.example.demo.domain.entities.Ingredient;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface IngredientService {
    List<Ingredient> findAllByNameStartingWith(String letters);

    List<Ingredient> findAllByNameIn(Collection<String> names);

    Ingredient findById(long id);

    @Modifying
    void updatePrice();

    void updatePriceByName(Collection<String> ingredientNames);
}
