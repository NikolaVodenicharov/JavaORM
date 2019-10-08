package entities.shampoos;

import entities.Size;
import entities.ingredients.BasicIngredient;
import entities.labels.BasicLabel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.HashSet;

@Entity
@DiscriminatorValue(value = "FN")
public class FreshNuke extends BasicShampoo{
    private static final String BRAND = "Fresh Nuke";
    private static final BigDecimal PRICE = new BigDecimal("9.33");
    private static final Size SIZE = Size.LARGE;

    public FreshNuke(){}

    public FreshNuke(BasicLabel label){
        super(BRAND, PRICE, SIZE, label, new HashSet<>());
    }
}
