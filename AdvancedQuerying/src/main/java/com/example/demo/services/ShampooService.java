package com.example.demo.services;

import com.example.demo.domain.entities.Ingredient;
import com.example.demo.domain.entities.Shampoo;
import com.example.demo.domain.entities.Size;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

public interface ShampooService {
    List<Shampoo> findAllBySize(Size size);

    List<Shampoo> findAllBySizeOrLabel_Id(Size size, long id);

    List<Shampoo> findAllByPriceGreaterThan(BigDecimal price);

    int countByPriceLessThan(BigDecimal price);

    List<Shampoo> findByIngredients(Collection<Ingredient> ingredients);

    List<Shampoo> allByIngredientsCountLessThan(int ingredientsCount);
}
