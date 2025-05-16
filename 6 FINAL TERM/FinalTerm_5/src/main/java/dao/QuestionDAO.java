package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.Category;
import model.Question;
import model.enums.Level;
import util.JPAUtils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Admin 5/10/2025
 **/
public class QuestionDAO {

    public List<Question> listQuestionsByLevelAndCategory(String categoryName, Level questionLevel) {

        try (EntityManager em = JPAUtils.getEntityManager()) {
            String jpql =
                    """
                    SELECT q 
                    FROM Question q
                    JOIN q.category c 
                    WHERE c.name LIKE CONCAT("%", :categoryName, "%")
                        AND q.questionLevel = :questionLevel
                    """;

            TypedQuery<Question> query = em.createQuery(jpql, Question.class);
            query.setParameter("categoryName", categoryName);
            query.setParameter("questionLevel", questionLevel);


            return query.getResultList();
        }
    }

    public Map<Level, Long> countQuestionsByLevelInQuiz(String quizId) {
        try (EntityManager em = JPAUtils.getEntityManager()) {
            String jpql =
                    """
                    SELECT qs.questionLevel, COUNT(qs.questionLevel)
                    FROM Question qs
                    JOIN qs.quizzes qu 
                    WHERE qu.id = :quizId
                    GROUP BY qs.questionLevel
                    ORDER BY COUNT(qs.questionLevel) DESC 
                    """;

            TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
            query.setParameter("quizId", quizId);

            return query
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

    public Question addQuestionToCategory(Question question, String categoryId) {

        try (EntityManager em = JPAUtils.getEntityManager()) {
            em.getTransaction().begin();

            Category category = em.find(Category.class, categoryId);
            if (category == null) return null;

            System.out.println(category);

            Question question2 = em.find(Question.class, question.getId());
            if (question2 != null) return null;


            question.setCategory(category);
            em.persist(question);

            em.getTransaction().commit();


            return question;
        }

    }
}
