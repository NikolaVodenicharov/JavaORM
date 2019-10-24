package spring.exercise.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.exercise.dataTransfareObjects.UserLoginDto;
import spring.exercise.dataTransfareObjects.UserRegisterDto;
import spring.exercise.entities.User;
import spring.exercise.repositories.UserRepository;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@Service
public class UserServiceImpl implements UserService {
    private static final String MESSAGE_CONFIRM_PASSWORD_NOT_MATCH = "Confirm password does not match.";
    private static final String MESSAGE_SUCCESSFUL_REGISTER = "User is saved successful";
    private static final String MESSAGE_EMAIL_ALREADY_EXIST = "User with that email is existing.";
    private static final String MESSAGE_USER_DOESNT_EXIST = "User does not exist.";
    private static final String MESSAGE_USER_ALREADY_LOGGED = "User already logged in.";
    private static final String MESSAGE_INCORRECT_PASSWORD = "Incorrect password.";
    private static final String MESSAGE_SUCCESSFUL_LOGGED = "User successful logged in.";
    private static final String MESSAGE_NO_LOGGED_USER = "There is no logged user.";
    private static final String MESSAGE_SUCCESSFUL_LOGOUT = "User logout is successfully.";

    private String loggedUserEmail = null;

    private UserRepository userRepository;
    private Validator validator;
    private ModelMapper mapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.validator = createValidator();
        this.mapper = createModelMapper();
    }

    private Validator createValidator(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        return factory.getValidator();
    }

    private ModelMapper createModelMapper(){
        return new ModelMapper();
    }

    @Override
    public String register(UserRegisterDto userRegisterDto) {
        var isConfirmPasswordMatches = userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword());
        if (!isConfirmPasswordMatches){
            return MESSAGE_CONFIRM_PASSWORD_NOT_MATCH;
        }

        var isUserEmailExist = userRepository.existsUserByEmail(userRegisterDto.getEmail());
        if (isUserEmailExist){
            return MESSAGE_EMAIL_ALREADY_EXIST;
        }

        var user = mapper.map(userRegisterDto, User.class);

        var violations = validator.validate(user);
        var areThereViolations = violations.size() > 0;
        if (areThereViolations){
            var builder = new StringBuilder();

            for (var violation : violations) {
                builder.append(violation.getMessage());
                builder.append(System.lineSeparator());
            }

            return builder.toString();
        }

        var isFirstUser = userRepository.count() == 0;
        if (isFirstUser){
            user.setIsAdministrator(true);
        }

        userRepository.saveAndFlush(user);

        return MESSAGE_SUCCESSFUL_REGISTER;
    }

    @Override
    public String login(UserLoginDto userLoginDto) {
        var isUserLoggedIn = loggedUserEmail != null;
        if (isUserLoggedIn){
            return MESSAGE_USER_ALREADY_LOGGED;
        }

        var isUserExist = userRepository.existsUserByEmail(userLoginDto.getEmail());
        if (!isUserExist){
            return MESSAGE_USER_DOESNT_EXIST;
        }

        var isPasswordCorrect = userRepository
                .existsUserByEmailAndPassword(
                    userLoginDto.getEmail(),
                    userLoginDto.getPassword());
        if (!isPasswordCorrect){
            return MESSAGE_INCORRECT_PASSWORD;
        }

        loggedUserEmail = userLoginDto.getEmail();
        return MESSAGE_SUCCESSFUL_LOGGED;
    }

    @Override
    public String logout() {
        var isLoggedUserExist = loggedUserEmail != null;
        if (!isLoggedUserExist){
            return MESSAGE_NO_LOGGED_USER;
        }

        loggedUserEmail = null;

        return MESSAGE_SUCCESSFUL_LOGOUT;
    }
}
