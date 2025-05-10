package util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Admin 5/10/2025
 **/
public class JPAUtils {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("mariadb");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }


}
