package com.example.demo.services;

import com.example.demo.domain.entities.Ingredient;
import com.example.demo.repositories.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService{
    private IngredientRepository repository;

    public IngredientServiceImpl(IngredientRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Ingredient> findAllByNameStartingWith(String letters) {
        return repository.findAllByNameStartingWith(letters);
    }

    @Override
    public List<Ingredient> findAllByNameIn(Collection<String> names) {
        return repository.findAllByNameIn(names);
    }
}
