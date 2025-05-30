package daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import models.Department;
import models.Staff;
import utils.EntityManagerUtil;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Admin 5/1/2025
 **/
public class DepartmentDAO {

    public static List<Department> findDepartmentHasMoreThan3Staffs() {

        try (EntityManager em = EntityManagerUtil.getEntityManager()) {
            String jpql =
                    """
                    SELECT d FROM Department d 
                    WHERE SIZE(d.staffs) > 3
                    """;

            TypedQuery<Department> query = em.createQuery(jpql, Department.class);


            List<Department> res = query.getResultList();

            return res;
        }

    }

    public static Map<Department, Long> countStaffByDepartment() {
        try (EntityManager em = EntityManagerUtil.getEntityManager()) {
            String jpql =
                    """
                    SELECT d, COUNT(s)
                    FROM Department d 
                    JOIN d.staffs s
                    GROUP BY d.name
                    """;

            TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);

            Map<Department, Long> res = query
                    .getResultList()
                    .stream()
                    .collect(Collectors.toMap(
                            x -> (Department)x[0],
                            x -> (Long) x[1],
                            (a, b) -> a,
                            LinkedHashMap::new
                    ));
            return res;
        }
    }

    public static List<Department> findDepartmentHasMoreStaffThanDepartment(String deptId) {
        try (EntityManager em = EntityManagerUtil.getEntityManager()) {
            String jpql =
                    """
                    SELECT d
                    FROM Department d 
                    WHERE SIZE(d.staffs) >= (
                        SELECT SIZE(d2.staffs)
                        FROM Department d2 
                        WHERE d2.id = :deptId
                    )
                    """;

            TypedQuery<Department> query = em.createQuery(jpql, Department.class);
            query.setParameter("deptId", deptId);

            return query.getResultList();
        }
    }

    public static List<Department> findDepartmentWithAvgAgeGreaterThan(int age) {
        try (EntityManager em = EntityManagerUtil.getEntityManager()) {
            String jpql =
                    """
                    SELECT d 
                    FROM Department d
                    JOIN d.staffs s 
                    GROUP BY d
                    HAVING AVG(s.age) >= :age
                    """;

            TypedQuery<Department> query = em.createQuery(jpql, Department.class);
            query.setParameter("age", age);

            return query.getResultList();
        }
    }
}
