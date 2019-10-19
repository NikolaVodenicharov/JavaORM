package com.example.demo;

import com.example.demo.repositories.ShampooRepository;
import com.example.demo.services.IngredientService;
import com.example.demo.services.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
@Component
public class ConsoleRunner implements CommandLineRunner {
    private ShampooService shampooService;
    private IngredientService ingredientService;
    private ShampooRepository repository;

    @Autowired
    public ConsoleRunner(ShampooService shampooService, IngredientService ingredientService, ShampooRepository repository) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        var names = new ArrayList<>(Arrays.asList("Apple", "Nettle"));

        ingredientService.updatePriceByName(names);
    }
}
