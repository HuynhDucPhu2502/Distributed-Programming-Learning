package daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import models.Department;
import models.OnlineCourse;
import utils.JPAUtil;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Admin 5/8/2025
 **/
public class DeparmentDAO {

    public Map<Department, Long> countCourseByDepartment() {

        try (EntityManager em = JPAUtil.getEntityManager()) {
            String jpql =
                    """
                    SELECT d, COUNT(c)
                    FROM Department d 
                    JOIN d.courses c
                    GROUP BY d  
                    """;


            TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);


            return query
                    .getResultList()
                    .stream()
                    .collect(Collectors.toMap(
                            obj -> (Department) obj[0],
                            obj -> (Long) obj[1],
                            (o1, o2) -> o1,
                            LinkedHashMap::new
                    ));

        }

    }


    public List<Department> findDepartmentWithMaxBudget() {

        try (EntityManager em = JPAUtil.getEntityManager()) {
            String jpql =
                    """
                    SELECT d 
                    FROM Department d 
                    WHERE d.budget = (
                        SELECT MAX(d2.budget)
                        FROM Department d2 
                    )
                    """;


            TypedQuery<Department> query = em.createQuery(jpql, Department.class);

            return query.getResultList();

        }

    }
}
