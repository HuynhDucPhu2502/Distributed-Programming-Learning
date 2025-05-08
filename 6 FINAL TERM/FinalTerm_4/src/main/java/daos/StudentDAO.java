package daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import models.OnlineCourse;
import models.Student;
import utils.JPAUtil;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Admin 5/8/2025
 **/
public class StudentDAO {

    public List<Student> findStudentByEnrollmentDateBetween(LocalDateTime startDate, LocalDateTime endDate){

        try (EntityManager em = JPAUtil.getEntityManager()) {
            String jpql =
                    """
                    SELECT s 
                    FROM Student s 
                    WHERE s.enrollmentDate BETWEEN :startDate AND :endDate
                    """;


            TypedQuery<Student> query = em.createQuery(jpql, Student.class);
            query.setParameter("startDate", startDate);
            query.setParameter("endDate", endDate);

            return query.getResultList();

        }

    }

}
