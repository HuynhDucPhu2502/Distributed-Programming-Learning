package utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Admin 5/14/2025
 **/
public class JPAUtil {

    private static final EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("mariadb");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

}
