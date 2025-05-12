package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.enums.Level;
import util.JPAUtils;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Admin 5/10/2025
 **/
public class QuizDAO {

    public Map<Level, Long> countQuestionsByLevelInQuiz(String quizId) {

        try (EntityManager em = JPAUtils.getEntityManager()) {
            String jpql =
                    """
                    SELECT qs.level, COUNT(qs.level)
                    FROM Question qs 
                    JOIN qs.quizzes qz
                    WHERE qz.id = :quizId
                    GROUP BY qs.level
                    ORDER BY COUNT(qs.level) DESC 
                    """;

            TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
            query.setParameter("quizId", quizId);

             return  query
                     .getResultList()
                     .stream()
                     .collect(Collectors.toMap(
                             obj -> (Level) obj[0],
                             obj -> (Long) obj[1],
                             (v1, v2) -> v1,
                             LinkedHashMap::new
                    ));
        }
    }
}
