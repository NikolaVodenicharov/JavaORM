package com.example.demo.services;

import com.example.demo.domain.entities.Shampoo;
import com.example.demo.domain.entities.Size;
import com.example.demo.repositories.ShampooRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ShampooServiceImpl implements ShampooService {
    private ShampooRepository repository;

    public ShampooServiceImpl(ShampooRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Shampoo> findAllBySize(Size size) {
        return repository.findAllBySizeOrderById(size);
    }

    @Override
    public List<Shampoo> findAllBySizeOrLabel_Id(Size size, long id) {
        return repository.findAllBySizeOrLabel_IdOrderByPrice(size, id);
    }

    @Override
    public List<Shampoo> findAllByPriceGreaterThan(BigDecimal price) {
        return repository.findAllByPriceGreaterThanOrderByPriceDesc(price);
    }

    @Override
    public int countByPriceLessThan(BigDecimal price) {
        return repository.countByPriceLessThan(price);
    }
}
