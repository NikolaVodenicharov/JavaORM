package spring.exercise.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.exercise.common.ValidatorExtensions;
import spring.exercise.dataTransfareObjects.GameCreateDto;
import spring.exercise.entities.Game;
import spring.exercise.repositories.GameRepository;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@Service
public class GameServiceImpl implements GameService{
    private static final String MESSAGE_GAME_EXIST = "Game already exist.";
    private static final String MESSAGE_GAME_DOESNT_EXIST = "Game does not exist.";
    private static final String MESSAGE_GAME_ADDED = "Game was added successful.";
    private static final String MESSAGE_GAME_DELETED = "Game was successfully deleted";

    private GameRepository gameRepository;
    private Validator validator;
    private ModelMapper mapper;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
        this.validator = createValidator();
        this.mapper = new ModelMapper();
    }

    private Validator createValidator(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        return factory.getValidator();
    }

    @Override
    public String add(GameCreateDto gameCreateDto) {
        var isGameExist = gameRepository.existsByTitle(gameCreateDto.getTitle());
        if (isGameExist){
            return MESSAGE_GAME_EXIST;
        }

        var game = mapper.map(gameCreateDto, Game.class);

        var violationMessages = ValidatorExtensions.getViolationMessages(game);
        if (violationMessages != null){
            return violationMessages;
        }

        gameRepository.saveAndFlush(game);

        return MESSAGE_GAME_ADDED;
    }

    @Override
    public String delete(int id) {
        var game = gameRepository.findById(id).orElse(null);

        var isGameExist = game != null;
        if (!isGameExist){
            return MESSAGE_GAME_DOESNT_EXIST;
        }

        gameRepository.delete(game);
        return MESSAGE_GAME_DELETED;
    }
}
