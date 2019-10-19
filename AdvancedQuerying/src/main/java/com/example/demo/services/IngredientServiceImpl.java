package com.example.demo.services;

import com.example.demo.domain.entities.Ingredient;
import com.example.demo.repositories.IngredientRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
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

    @Override
    public Ingredient findById(long id) {
        return repository.getOne(id);
    }

    @Override
    public void updatePrice() {
        repository.updateAllPrice();
    }

    @Override
    public void updatePriceByName(Collection<String> ingredientNames) {
        repository.updatePriceByName(ingredientNames);
    }
}
