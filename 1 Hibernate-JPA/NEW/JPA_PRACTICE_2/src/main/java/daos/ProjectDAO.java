package daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import models.Project;
import utils.EntityManagerUtil;

import java.util.List;

/**
 * Admin 5/1/2025
 **/
public class ProjectDAO {

    public static List<Project> findProjectByMinBudget(double minBudget) {

        try (EntityManager em = EntityManagerUtil.getEntityManager()) {
            String jpql =
                    """
                    SELECT p FROM Project p 
                    WHERE p.budget >= :minBudget
                    """;

            TypedQuery<Project> query = em.createQuery(jpql, Project.class);
            query.setParameter("minBudget", minBudget);

            return query.getResultList();
        }

    }

    public static List<Project> findProjectHasStaffs() {

        try (EntityManager em = EntityManagerUtil.getEntityManager()) {
            String jpql =
                    """
                    SELECT p FROM Project p 
                    WHERE SIZE(p.staffs) > 0
                    """;

            TypedQuery<Project> query = em.createQuery(jpql, Project.class);

            return query.getResultList();
        }

    }

    public static List<Project> findProjectsHasMoreStaffThanAverage() {

        try (EntityManager em = EntityManagerUtil.getEntityManager()) {
            String jpql =
                    """
                    SELECT p FROM Project p 
                    WHERE SIZE(p.staffs) > (
                        SELECT AVG(SIZE(p2.staffs))
                        FROM Project p2
                    )
                    """;

            TypedQuery<Project> query = em.createQuery(jpql, Project.class);

            return query.getResultList();
        }

    }

}
