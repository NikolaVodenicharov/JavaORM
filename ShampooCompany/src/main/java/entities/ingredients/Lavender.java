package entities.ingredients;

import entities.shampoos.BasicShampoo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.List;

@Entity
@DiscriminatorValue(value = "LA")
public class Lavender extends BasicIngredient{
    private static final String NAME = "Lavender";
    private static final BigDecimal PRICE = new BigDecimal("2.00");

    public Lavender(){
        super(NAME, PRICE);
    }
}
