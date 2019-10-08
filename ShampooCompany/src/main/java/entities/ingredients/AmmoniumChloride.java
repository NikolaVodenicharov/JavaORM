package entities.ingredients;

import entities.shampoos.BasicShampoo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.List;

@Entity
@DiscriminatorValue(value = "AM")
public class AmmoniumChloride extends BasicChemicalIngredient{
    private static final String NAME = "AmmoniumChloride";
    private static final BigDecimal PRICE = new BigDecimal("6.12");
    private static final String CHEMICAL_FORMULA = "NH4CL";

    public AmmoniumChloride(){
        super(NAME, PRICE, CHEMICAL_FORMULA);
    }
}
