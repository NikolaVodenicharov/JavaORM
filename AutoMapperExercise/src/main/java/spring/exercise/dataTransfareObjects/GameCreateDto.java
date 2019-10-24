package spring.exercise.dataTransfareObjects;

import spring.exercise.entities.Order;
import spring.exercise.entities.User;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public class GameCreateDto {
    private String title;
    private String trailer;
    private String imageUrl;
    private double Size;
    private BigDecimal price;
    private String description;
    private Date releaseDate;

    public GameCreateDto() {
    }

    public GameCreateDto(String title, String trailer, String imageUrl, double size, BigDecimal price, String description, Date releaseDate) {
        this.title = title;
        this.trailer = trailer;
        this.imageUrl = imageUrl;
        Size = size;
        this.price = price;
        this.description = description;
        this.releaseDate = releaseDate;
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
}
