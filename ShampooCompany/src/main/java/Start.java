import entities.ingredients.AmmoniumChloride;
import entities.ingredients.Mint;
import entities.ingredients.Nettle;
import entities.labels.BasicLabel;
import entities.shampoos.FreshNuke;

import javax.persistence.Persistence;

public class Start {
    public static void main (String[] args) {
        var entityManagerFactory = Persistence.createEntityManagerFactory("ShampooCompany");
        var entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        var ammoniumChloride = new AmmoniumChloride();
        var mint = new Mint();
        var nettle = new Nettle();

        var label = new BasicLabel("Fresh Nuke Shampoo", "Contains mint and nettle");

        var shampoo = new FreshNuke(label);

        shampoo.getIngredients().add(mint);
        shampoo.getIngredients().add(nettle);
        shampoo.getIngredients().add(ammoniumChloride);

        entityManager.persist(shampoo);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
