package spring.exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import spring.exercise.dataTransfareObjects.GameCreateDto;
import spring.exercise.dataTransfareObjects.UserLoginDto;
import spring.exercise.dataTransfareObjects.UserRegisterDto;
import spring.exercise.services.GameService;
import spring.exercise.services.UserService;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

@SpringBootApplication
public class App implements CommandLineRunner {
    private UserService userService;
    private GameService gameService;

    @Autowired
    public App(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }

    @Override
    public void run(String... args) throws Exception {
        executeInstructions();
    }

    private void executeInstructions() throws ParseException {
        var scanner = new Scanner(System.in);

        while(true){
            var instructions = scanner.nextLine().split("\\|");
            var command = instructions[0];

            switch (command){
                case "RegisterUser":
                    registerUser(instructions);
                    break;
                case "LoginUser":
                    loginUser(instructions);
                    break;
                case "Logout":
                    logoutUser();
                    break;
                case "AddGame":
                    addGame(instructions);
                    break;
                case "DeleteGame":
                    deleteGame(instructions);
                    break;
            }
        }
    }

    private void deleteGame(String[] instructions) {
        var id = Integer.parseInt(instructions[1]);

        var message = gameService.delete(id);
        System.out.println(message);
    }

    private void addGame(String[] instructions) throws ParseException {
        var title = instructions[1];
        var price = new BigDecimal(instructions[2]);
        var size = Double.parseDouble(instructions[3]);
        var trailer = instructions[4];
        var imageUrl = instructions[5];
        var description = instructions[6];
        var releaseDate = new SimpleDateFormat("dd-mm-yyyy").parse(instructions[7]);

        //(String title, String trailer, String imageUrl, double size, BigDecimal price, String description, Date releaseDate)
        var gameDto = new GameCreateDto(title, trailer, imageUrl, size, price, description, releaseDate );

        var message = gameService.add(gameDto);
        System.out.println(message);
    }

    private void registerUser(String[] instructions){
        var email = instructions[1];
        var password = instructions[2];
        var confirmPassword = instructions[3];
        var name = instructions[4];

        var userDto = new UserRegisterDto(name, email, password, confirmPassword);
        var message = userService.register(userDto);

        System.out.println(message);
    }

    private void loginUser(String[] instructions){
        var email = instructions[1];
        var password = instructions[2];

        var userDto = new UserLoginDto(email, password);
        var message = userService.login(userDto);

        System.out.println(message);
    }

    private void logoutUser(){
        var message = userService.logout();
        System.out.println(message);
    }

    private String[] extractPascalCaseWords(String pascalCaseWords){
        if (pascalCaseWords == null){
            return null;
        }
        if (pascalCaseWords.isEmpty()){
            return null;
        }

        var pattern = "(?<=[A-Z])(?=[A-Z][a-z])|(?<=[^A-Z])(?=[A-Z])|(?<=[A-Za-z])(?=[^A-Za-z])";
        var words = pascalCaseWords.split(pattern);
        return words;
    }
}
