package spring.exercise.services;

import spring.exercise.dataTransfareObjects.UserLoginDto;
import spring.exercise.dataTransfareObjects.UserRegisterDto;

public interface UserService {
    String register(UserRegisterDto userRegisterDto);
    String login(UserLoginDto userLoginDto);
    String logout();
}
