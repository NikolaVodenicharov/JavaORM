package com.example.demo.services;

import com.example.demo.domain.entities.Ingredient;

import java.util.Collection;
import java.util.List;

public interface IngredientService {
    List<Ingredient> findAllByNameStartingWith(String letters);

    List<Ingredient> findAllByNameIn(Collection<String> names);
}
