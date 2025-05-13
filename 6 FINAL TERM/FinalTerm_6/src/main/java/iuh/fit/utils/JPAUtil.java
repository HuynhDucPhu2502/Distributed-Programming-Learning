package iuh.fit.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Admin 5/13/2025
 **/
public class JPAUtil {

    private static final EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("mariadb");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

}
