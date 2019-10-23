package spring.exercise.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.exercise.entities.City;
import spring.exercise.repositories.CityRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class CityServiceImpl implements CityService {
    private CityRepository repository;

    @Autowired
    public CityServiceImpl(CityRepository repository) {
        this.repository = repository;
    }

    public void save(City city) {
        repository.saveAndFlush(city);
    }
}
