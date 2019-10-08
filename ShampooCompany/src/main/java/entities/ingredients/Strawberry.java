package entities.ingredients;

import entities.shampoos.BasicShampoo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.List;

@Entity
@DiscriminatorValue(value = "ST")
public class Strawberry extends BasicIngredient {
    private static final String NAME = "Strawberry";
    private static final BigDecimal PRICE = new BigDecimal("4.85");

    public Strawberry(){
        super(NAME, PRICE);
    }
}
