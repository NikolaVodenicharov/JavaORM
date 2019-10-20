package spring.intro.entities.dto;

import spring.intro.entities.enums.AgeRestriction;
import spring.intro.entities.enums.Edition;

import java.math.BigDecimal;

public class BookSummaryDto {
    private String title;
    private Edition edition;
    private AgeRestriction restriction;
    private BigDecimal price;

    public BookSummaryDto(String title, Edition edition, AgeRestriction restriction, BigDecimal price) {
        this.title = title;
        this.edition = edition;
        this.restriction = restriction;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Edition getEdition() {
        return edition;
    }

    public void setEdition(Edition edition) {
        this.edition = edition;
    }

    public AgeRestriction getRestriction() {
        return restriction;
    }

    public void setRestriction(AgeRestriction restriction) {
        this.restriction = restriction;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
