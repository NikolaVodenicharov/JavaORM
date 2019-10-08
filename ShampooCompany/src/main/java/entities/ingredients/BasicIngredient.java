package entities.ingredients;

import entities.shampoos.BasicShampoo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "ingredients")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ingredient_type", discriminatorType = DiscriminatorType.STRING)
public abstract class BasicIngredient implements Ingredient{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private BigDecimal price;

    @ManyToMany(mappedBy = "ingredients", cascade = CascadeType.ALL)
    private List<BasicShampoo> shampoos;

    protected BasicIngredient(){};
    protected BasicIngredient(String name, BigDecimal price){
        this.setName(name);
        this.setPrice(price);
    }

    @Override
    public long getId() {
        return this.id;
    }
    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }
    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public List<BasicShampoo> getShampoos() {
        return this.shampoos;
    }
    @Override
    public void setShampoos(List<BasicShampoo> shampoos) {
        this.shampoos = shampoos;
    }
}
