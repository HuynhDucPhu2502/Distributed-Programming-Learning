package daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import models.Course;
import models.Department;
import models.OnlineCourse;
import models.OnsiteCourse;
import utils.JPAUtil;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Admin 5/8/2025
 **/
public class CourseDAO {

    public List<Course> findCourseByCreditsBetween(int minCredits, int maxCredits) {

        try (EntityManager em = JPAUtil.getEntityManager()) {
            String jpql =
                    """
                    SELECT c 
                    FROM Course c 
                    WHERE c.credits BETWEEN :minCredits AND :maxCredits
                    """;


            TypedQuery<Course> query = em.createQuery(jpql, Course.class);
            query.setParameter("minCredits", minCredits);
            query.setParameter("maxCredits", maxCredits);

            return query.getResultList();

        }

    }

    public List<Course> findCourseByDepartmentNameContaining(String deptName) {

        try (EntityManager em = JPAUtil.getEntityManager()) {
            String jpql =
                    """
                    SELECT c 
                    FROM Course c 
                    JOIN c.department d 
                    WHERE d.name LIKE CONCAT("%", :deptName, "%")
                    """;


            TypedQuery<Course> query = em.createQuery(jpql, Course.class);
            query.setParameter("deptName", deptName);

            return query.getResultList();

        }

    }

    public List<OnlineCourse> findOnlineCourseByUrlContainingAndCreditsGreaterThanEqual(String urlKeyword, int minCredits) {

        try (EntityManager em = JPAUtil.getEntityManager()) {
            String jpql =
                    """
                    SELECT oc 
                    FROM OnlineCourse oc 
                    WHERE oc.url LIKE CONCAT("%", :urlKeyword, "%") AND oc.credits >= :minCredits
                    """;


            TypedQuery<OnlineCourse> query = em.createQuery(jpql, OnlineCourse.class);
            query.setParameter("urlKeyword", urlKeyword);
            query.setParameter("minCredits", minCredits);

            return query.getResultList();

        }

    }


    public Map<Course, Long> countStudentsByCourse() {

        try (EntityManager em = JPAUtil.getEntityManager()) {
            String jpql =
                    """
                    SELECT c, COUNT(DISTINCT s) 
                    FROM Course c 
                    JOIN c.studentGrades sg 
                    JOIN sg.student s 
                    GROUP BY c 
                    """;


            TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);


            return query
                    .getResultList()
                    .stream()
                    .collect(Collectors.toMap(
                            obj -> (Course) obj[0],
                            obj -> (Long) obj[1],
                            (o1, o2) -> o1,
                            LinkedHashMap::new
                    ));

        }

    }


    // WHF
    public List<OnsiteCourse> findOnsiteCourseByDaysContaining(String dayKeyword) {

        try (EntityManager em = JPAUtil.getEntityManager()) {
            StringBuilder jpql = new StringBuilder(
                    """
                    SELECT oc
                    FROM OnsiteCourse oc 
                    WHERE 
                    """
            );

            // Input: String WHF
            ArrayList<Character> chars = (ArrayList<Character>) dayKeyword
                    .chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.toList());
            // Output: [W, H, F]

            for (int i = 0; i < chars.size(); i++) {
                jpql.append("oc.days LIKE :p").append(i);
                if (i < chars.size() - 1) jpql.append(" AND ");
            }
//            """
//            SELECT oc
//            FROM OnsiteCourse oc
//            WHERE oc.days LIKE :p0 AND oc.days LIKE :p1 AND ....
//            """;


            TypedQuery<OnsiteCourse> query = em.createQuery(jpql.toString(), OnsiteCourse.class);

            // Tránh SQL Injection
            for (int i = 0; i < chars.size(); i++) query.setParameter("p" + i, "%" + chars.get(i) + "%");
//            """
//            SELECT oc
//            FROM OnsiteCourse oc
//            WHERE oc.days LIKE '%W%' AND oc.days LIKE '%H%' AND oc.days LIKE '%F%'
//            """;



            return query.getResultList();
        }
    }


}
