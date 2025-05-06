package daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import models.Department;
import models.Project;
import utils.EntityManagerUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Admin 5/4/2025
 **/
public class DepartmentDAO {

    public List<Department> findDepartmentHasMoreThan3Staffs() {

        try (EntityManager em = EntityManagerUtil.getEntityManager()) {
            String jpql =
                    """
                    SELECT d 
                    FROM Department d 
                    WHERE SIZE(d.staffs) > 3
                    """;

            TypedQuery<Department> query = em.createQuery(jpql, Department.class);

            return query.getResultList();
        }
    }


    public Map<Department, Long> countStaffByDepartment() {

        try (EntityManager em = EntityManagerUtil.getEntityManager()) {
//            String jpql =
//                    """
//                    SELECT d, SIZE(d.staffs)
//                    FROM Department d
//                    """;
            String jpql =
                    """
                    SELECT d, COUNT(s)
                    FROM Department d 
                    JOIN d.staffs s 
                    GROUP BY d.name
                    """;

            TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);

            Map<Department, Long> res = query.getResultList()
                    .stream()
                    .collect(Collectors.toMap(
                            obj -> (Department) obj[0],
                            obj -> (Long) obj[1]
                    ));

            return res;
        }
    }

    public List<Department> findDepartmentHasMoreStaffThanDepartment(String deptId) {

        try (EntityManager em = EntityManagerUtil.getEntityManager()) {
            String jpql =
                    """
                    SELECT d
                    FROM Department d 
                    WHERE SIZE(d.staffs) > (
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

    public List<Department> findDepartmentWithAvgAgeGreaterThan(int age) {

        try (EntityManager em = EntityManagerUtil.getEntityManager()) {
            String jpql =
                    """
                    SELECT d
                    FROM Department d 
                    JOIN d.staffs s
                    GROUP BY d
                    HAVING AVG(s.age) > :age
                    """;

            TypedQuery<Department> query = em.createQuery(jpql, Department.class);
            query.setParameter("age", age);

            return query.getResultList();
        }
    }
}
