package entities.ingredients;

import entities.shampoos.BasicShampoo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.List;

@Entity
@DiscriminatorValue(value = "NE")
public class Nettle extends BasicIngredient {
    private static final String NAME = "Nuttle";
    private static final BigDecimal PRICE = new BigDecimal("6.12");

    public Nettle(){
        super(NAME, PRICE);
    }
}
