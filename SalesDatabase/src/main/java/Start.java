import entities.StoreLocation;

import javax.persistence.Persistence;

public class Start {
    public static void main (String[] args){
        var entityManagerFactory = Persistence.createEntityManagerFactory("Sales_Database");
        var entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        var storeLocation = new StoreLocation("s");
        entityManager.persist(storeLocation);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
