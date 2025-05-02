package daos;

import jakarta.persistence.EntityManager;
import models.Quiz;
import utils.EntityManagerUtil;

import java.util.List;

/**
 * Admin 4/24/2025
 **/
public class QuizDAO {

    public static List<Quiz> findAllQuizWithCategoryName() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        String jpql = """
                SELECT q FROM Quiz q JOIN q.category c
                """;

        try {

            return em.createQuery(jpql, Quiz.class).getResultList();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Quiz> findQuizWithHighScore() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        String jpql = """
                SELECT q FROM Quiz q JOIN q.category c
                WHERE q.score >= 9
                """;

        try {

            return em.createQuery(jpql, Quiz.class).getResultList();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Quiz> findQuizStartingWithA() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        String jpql = """
                SELECT q FROM Quiz q 
                WHERE q.title LIKE 'A%'
                """;

        try {

            return em.createQuery(jpql, Quiz.class).getResultList();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
