package com.example.demo.services;

import com.example.demo.domain.entities.Shampoo;
import com.example.demo.domain.entities.Size;

import java.math.BigDecimal;
import java.util.List;

public interface ShampooService {
    List<Shampoo> findAllBySize(Size size);

    List<Shampoo> findAllBySizeOrLabel_Id(Size size, long id);

    List<Shampoo> findAllByPriceGreaterThan(BigDecimal price);

    int countByPriceLessThan(BigDecimal price);
}
