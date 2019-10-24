package spring.exercise.dataTransfareObjects;

import spring.exercise.entities.Game;
import spring.exercise.entities.Order;

import java.util.Set;

public class UserDto {
    private String name;
    private String email;
    private String password;
    private boolean isAdministrator;
    private Set<Order> orders;
    private Set<Game> games;

    public UserDto() {
    }

    public UserDto(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.isAdministrator = isAdministrator;
        this.orders = orders;
        this.games = games;
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

    public boolean isAdministrator() {
        return isAdministrator;
    }
    public void setAdministrator(boolean administrator) {
        isAdministrator = administrator;
    }

    public Set<Order> getOrders() {
        return orders;
    }
    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Set<Game> getGames() {
        return games;
    }
    public void setGames(Set<Game> games) {
        this.games = games;
    }
}
