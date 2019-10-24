package spring.exercise.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.exercise.dataTransfareObjects.UserRegisterDto;
import spring.exercise.entities.User;
import spring.exercise.repositories.UserRepository;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@Service
public class UserServiceImpl implements UserService {
    private static final String MESSAGE_CONFIRM_PASSWORD_NOT_MATCH = "Confirm password does not match.";
    private static final String MESSAGE_SUCCESSFUL_SAVED = "User is saved successful";
    private static final String MESSAGE_EMAIL_EXIST = "User with that email is existing.";

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
    public String save(UserRegisterDto userRegisterDto) {
        var isConfirmPasswordMatches = userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword());
        if (!isConfirmPasswordMatches){
            return MESSAGE_CONFIRM_PASSWORD_NOT_MATCH;
        }

        var isUserEmailExist = userRepository.existsUserByEmail(userRegisterDto.getEmail());
        if (isUserEmailExist){
            return MESSAGE_EMAIL_EXIST;
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

        return MESSAGE_SUCCESSFUL_SAVED;
    }
}
