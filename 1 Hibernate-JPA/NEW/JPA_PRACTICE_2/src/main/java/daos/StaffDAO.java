package daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import models.Project;
import models.Staff;
import utils.EntityManagerUtil;

import java.util.List;

/**
 * Admin 5/1/2025
 **/
public class StaffDAO {

    public static List<Staff> findStaffByNameKeyword(String keyword) {

        try (EntityManager em = EntityManagerUtil.getEntityManager()) {
            String jpql =
                    """
                    SELECT s FROM Staff s 
                    WHERE s.name LIKE CONCAT("%", :keyword, "%") 
                    """;

            TypedQuery<Staff> query = em.createQuery(jpql, Staff.class);
            query.setParameter("keyword", keyword);

            List<Staff> res = query.getResultList();

            return res;
        }

    }

    public static List<Staff> findStaffByAgeBetween(int minAge, int maxAge) {

        try (EntityManager em = EntityManagerUtil.getEntityManager()) {
            String jpql =
                    """
                    SELECT s FROM Staff s 
                    WHERE s.age BETWEEN :minAge and :maxAge
                    """;

            TypedQuery<Staff> query = em.createQuery(jpql, Staff.class);

            query.setParameter("minAge", minAge);
            query.setParameter("maxAge", maxAge);

            List<Staff> res = query.getResultList();

            return res;
        }

    }

    public static List<Staff> findStaffWithoutProject() {

        try (EntityManager em = EntityManagerUtil.getEntityManager()) {
            String jpql =
                    """
                    SELECT s FROM Staff s 
                    WHERE SIZE(s.projects) = 0
                    """;

            TypedQuery<Staff> query = em.createQuery(jpql, Staff.class);


            List<Staff> res = query.getResultList();

            return res;
        }

    }

    public static List<Staff> findStaffByPhone(String phone) {

        try (EntityManager em = EntityManagerUtil.getEntityManager()) {
            String jpql =
                    """
                    SELECT s FROM Staff s 
                    JOIN s.phoneNumbers p 
                    WHERE p = :phone
                    """;

            TypedQuery<Staff> query = em.createQuery(jpql, Staff.class);

            query.setParameter("phone", phone);


            List<Staff> res = query.getResultList();

            return res;
        }

    }

    public static List<Staff> findStaffInProjectWithMaxBudget() {

        try (EntityManager em = EntityManagerUtil.getEntityManager()) {
            String jpql =
                    """
                    SELECT DISTINCT s FROM Staff s 
                    JOIN s.projects p
                    WHERE p.budget = (
                        SELECT MAX(p2.budget)
                        FROM Project p2
                    )
                    """;

            TypedQuery<Staff> query = em.createQuery(jpql, Staff.class);



            List<Staff> res = query.getResultList();

            return res;
        }

    }

    public static List<Staff> findStaffNotJoinLowBudgetProject(double budget) {

        try (EntityManager em = EntityManagerUtil.getEntityManager()) {
            String jpql =
                    """
                    SELECT s 
                    FROM Staff s 
                    WHERE NOT EXISTS (
                        SELECT p
                        FROM Project p 
                        JOIN p.staffs s2
                        WHERE p.budget < :budget AND s2 = s
                    )
                    """;

            TypedQuery<Staff> query = em.createQuery(jpql, Staff.class);
            query.setParameter("budget", budget);



            List<Staff> res = query.getResultList();

            return res;
        }

    }





}
