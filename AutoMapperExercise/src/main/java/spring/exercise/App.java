package spring.exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import spring.exercise.dataTransfareObjects.UserRegisterDto;
import spring.exercise.services.UserService;

import java.util.Scanner;

@SpringBootApplication
public class App implements CommandLineRunner {
    private UserService userService;

    @Autowired
    public App(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        executeInstructions();
    }

    private void executeInstructions(){
        var scanner = new Scanner(System.in);
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
        }


    }

    private void registerUser(String[] instructions){
        var email = instructions[1];
        var password = instructions[2];
        var confirmPassword = instructions[3];
        var name = instructions[4];

        var userDto = new UserRegisterDto(name, email, password, confirmPassword);
        var message = userService.save(userDto);

        System.out.println(message);
    }

    private void loginUser(String[] instructions){
        var email = instructions[1];
        var password = instructions[2];


    }

    private void logoutUser(){

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
