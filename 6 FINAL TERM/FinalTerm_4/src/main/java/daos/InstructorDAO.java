package daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import models.Instructor;
import models.Student;
import utils.JPAUtil;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Admin 5/8/2025
 **/
public class InstructorDAO {

    public List<Instructor> findInstructorByOfficeAssignmentTimestampBefore(LocalDateTime timestamp){

        try (EntityManager em = JPAUtil.getEntityManager()) {
            String jpql =
                    """
                    SELECT i 
                    FROM Instructor i
                    JOIN i.officeAssignment oa 
                    WHERE oa.timestamp < :timestamp
                    """;


            TypedQuery<Instructor> query = em.createQuery(jpql, Instructor.class);
            query.setParameter("timestamp", timestamp);

            return query.getResultList();

        }

    }

}

