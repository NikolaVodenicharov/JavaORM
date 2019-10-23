package spring.exercise.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "games")
public class Game {
    private static final String BASE_YOUTUBE_URL = "https://www.youtube.com/watch?v=";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters long.")
    @Pattern(regexp = "^([A-Z]\\w+)$", message = "Title must start with upper case letter")
    private String title;

    @Size(min = 11, max = 11, message = "Trailer id url must be exactly 11 characters long. From YouTube.")
    private String trailer;

    @Column(name = "image_url")
    @Pattern(regexp = "^(http:\\/\\/|https:\\/\\/)[a-z0-9]+([\\-\\.]{1}[a-z0-9]+)*\\.[a-z]{2,5}(:[0-9]{1,5})?(\\/.*)?$")
    private String imageUrl;

    @Min(0)
    @Column(precision = 1)
    private double Size;

    private BigDecimal price;

    @Size(min = 20)
    private String description;

    @Column(name = "release_date")
    private Date releaseDate;

    @ManyToMany(mappedBy = "games")
    private Set<User> users;

    @ManyToMany(mappedBy = "products")
    private Set<Order> orders;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTrailer() {
        return trailer;
    }
    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getSize() {
        return Size;
    }
    public void setSize(double size) {
        if(price.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Price must be positive number.");
        }

        Size = size;
    }

    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Set<User> getUsers() {
        return users;
    }
    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Order> getOrders() {
        return orders;
    }
    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
