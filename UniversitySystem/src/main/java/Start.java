import javax.persistence.Persistence;

public class Start {
    public static void main(String[] args) {
        var entityManagerFactory = Persistence.createEntityManagerFactory("university_system");
        var entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();



        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
