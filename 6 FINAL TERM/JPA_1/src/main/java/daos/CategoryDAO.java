package daos;

import jakarta.persistence.EntityManager;
import models.Category;
import models.Quiz;
import utils.EntityManagerUtil;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Admin 4/24/2025
 **/
public class CategoryDAO {
    public static Map<Category, Long> countQuizInEachCategory() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        String jpql = """
                SELECT c, COUNT(q) FROM Category c 
                LEFT JOIN c.quizzes q
                GROUP BY c
                """;

        try {
            List<Object[]> resultList = em.createQuery(jpql, Object[].class).getResultList();

            Map<Category, Long> result = resultList.stream()
                    .collect(Collectors.toMap(
                            row -> (Category) row[0],
                            row -> (Long) row[1],
                            (x, y) -> x,
                            LinkedHashMap::new
                    ));

            return result;


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Map<Category, Quiz> findTopScoringQuizInEachCategory() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        String jpql = """
                SElECT q FROM Quiz q 
                WHERE q.score = (SELECT q2.score FROM Quiz q2 WHERE q2.category = q.category)
                """;

        try {
            List<Quiz> resultList = em.createQuery(jpql, Quiz.class).getResultList();

            Map<Category, Quiz> result = resultList.stream()
                    .collect(Collectors.toMap(
                            quiz -> quiz.getCategory(),
                            quiz -> quiz,
                            (x, y) -> x,
                            LinkedHashMap::new
                    ));

            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Map<Category, Long> sumQuizScoreByCategory() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        String jpql = """
                SELECT c, SUM(q.score) FROM Category c
                LEFT JOIN c.quizzes q
                GROUP BY c
                """;

        try {
            List<Object[]> resultList = em.createQuery(jpql, Object[].class).getResultList();

            Map<Category, Long> result = resultList.stream()
                    .collect(Collectors.toMap(
                            row -> (Category) row[0],
                            row -> (Long) row[1],
                            (x, y) -> x,
                            LinkedHashMap::new
                    ));

            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Map<Category, Double> findCategoryWithLowestAverageScore() {
        EntityManager em = EntityManagerUtil.getEntityManager();

        String sql = """
        SELECT c.category_id, c.name, c.description, sub.avg_score
        FROM categories c
        JOIN (
            SELECT category_id, AVG(score) AS avg_score
            FROM quizzes
            GROUP BY category_id
            HAVING AVG(score) = (
                SELECT MIN(avg_score) FROM (
                    SELECT AVG(score) AS avg_score
                    FROM quizzes
                    GROUP BY category_id
                ) AS inner_avg
            )
        ) sub ON c.category_id = sub.category_id
        """;


        try {
            List<Object[]> rows = em.createNativeQuery(sql).getResultList();

            Map<Category, Double> result = rows.stream()
                    .collect(Collectors.toMap(
                            row -> {
                                Category c = new Category();
                                c.setId((String) row[0]);
                                c.setName((String) row[1]);
                                c.setDescription((String) row[2]);
                                return c;
                            },
                            row -> ((Number) row[3]).doubleValue(),
                            (a, b) -> a,
                            LinkedHashMap::new
                    ));


            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



}
