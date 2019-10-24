package spring.exercise.dataTransfareObjects;

import spring.exercise.entities.Game;
import spring.exercise.entities.Order;

import java.util.Set;

public class UserRegisterDto {
    private String name;
    private String email;
    private String password;
    private String confirmPassword;
    private boolean isAdministrator;

    public UserRegisterDto() {
    }

    public UserRegisterDto(String name, String email, String password, String confirmPassword) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public boolean getIsAdministrator() {
        return isAdministrator;
    }
    public void setIsAdministrator(boolean administrator) {
        isAdministrator = administrator;
    }
}
