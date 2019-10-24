package spring.exercise.services;

import spring.exercise.dataTransfareObjects.UserRegisterDto;

public interface UserService {
    String save(UserRegisterDto userRegisterDto);
}
