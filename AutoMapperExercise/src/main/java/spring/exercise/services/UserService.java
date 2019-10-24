package spring.exercise.services;

import spring.exercise.dataTransfareObjects.UserDto;

public interface UserService {
    String save(UserDto userDto, String confirmPassword);
}
