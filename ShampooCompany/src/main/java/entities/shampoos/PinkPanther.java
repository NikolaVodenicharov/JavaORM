package entities.shampoos;

import entities.Size;
import entities.labels.BasicLabel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.HashSet;

@Entity
@DiscriminatorValue(value = "PP")
public class PinkPanther extends BasicShampoo{
    private static final String BRAND = "Fresh Nuke";
    private static final BigDecimal PRICE = new BigDecimal("8.50");
    private static final Size SIZE = Size.MEDIUM;

    public PinkPanther(){}

    public PinkPanther(BasicLabel label){
        super(BRAND, PRICE, SIZE, label, new HashSet<>());
    }
}
