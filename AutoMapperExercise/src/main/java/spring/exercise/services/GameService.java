package spring.exercise.services;

import spring.exercise.dataTransfareObjects.GameCreateDto;

public interface GameService {
    String add(GameCreateDto gameCreateDto);
    String delete(int id);
}
