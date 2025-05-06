package daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import models.Staff;
import utils.EntityManagerUtil;

import java.util.List;

/**
 * Admin 5/4/2025
 **/
public class StaffDAO {

    public List<Staff> findStaffByNameKeyword(String keyword) {

        try (EntityManager em = EntityManagerUtil.getEntityManager()) {
            String jpql =
                    """
                    SELECT s 
                    FROM Staff s 
                    WHERE s.name LIKE CONCAT("%", :keyword, "%")
                    """;

            TypedQuery<Staff> query = em.createQuery(jpql, Staff.class);
            query.setParameter("keyword", keyword);

            return query.getResultList();
        }

    }

    public List<Staff> findStaffByAgeBetween(int minAge, int maxAge) {

        try (EntityManager em = EntityManagerUtil.getEntityManager()) {
            String jpql =
                    """
                    SELECT s 
                    FROM Staff s 
                    WHERE s.age BETWEEN :minAge and :maxAge
                    """;

            TypedQuery<Staff> query = em.createQuery(jpql, Staff.class);
            query.setParameter("minAge", minAge);
            query.setParameter("maxAge", maxAge);

            return query.getResultList();
        }
    }

    public List<Staff> findStaffWithoutProject() {

        try (EntityManager em = EntityManagerUtil.getEntityManager()) {
            String jpql =
                    """
                    SELECT s 
                    FROM Staff s 
                    WHERE SIZE(s.projects) = 0
                    """;

            TypedQuery<Staff> query = em.createQuery(jpql, Staff.class);

            return query.getResultList();
        }
    }


    public List<Staff> findStaffByPhone(String phone) {

        try (EntityManager em = EntityManagerUtil.getEntityManager()) {
            String jpql =
                    """
                    SELECT s 
                    FROM Staff s 
                    JOIN s.phoneNumbers phoneNumber 
                    WHERE phoneNumber = :phone
                    """;

            TypedQuery<Staff> query = em.createQuery(jpql, Staff.class);
            query.setParameter("phone", phone);


            return query.getResultList();
        }
    }

    public List<Staff> findStaffInProjectWithMaxBudget() {

        try (EntityManager em = EntityManagerUtil.getEntityManager()) {
            String jpql =
                    """
                    SELECT s 
                    FROM Staff s 
                    JOIN s.projects p 
                    WHERE p.budget >= (
                        SELECT MAX(p2.budget)
                        FROM Project p2 
                    )
                    """;

            TypedQuery<Staff> query = em.createQuery(jpql, Staff.class);


            return query.getResultList();
        }
    }


    public List<Staff> findStaffNotJoinLowBudgetProject(double budget) {

        try (EntityManager em = EntityManagerUtil.getEntityManager()) {
            String jpql =
                    """
                    SELECT s 
                    FROM Staff s 
                    WHERE NOT EXISTS (
                        SELECT p
                        FROM s.projects p
                        WHERE p.budget < :budget 
                    ) AND SIZE(s.projects) > 0
                    """;

            TypedQuery<Staff> query = em.createQuery(jpql, Staff.class);
            query.setParameter("budget", budget);


            return query.getResultList();
        }
    }



}
