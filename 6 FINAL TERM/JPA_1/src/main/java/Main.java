import daos.CategoryDAO;
import daos.QuizDAO;
import jakarta.persistence.EntityManager;
import models.Quiz;
import utils.EntityManagerUtil;

import java.util.List;

/**
 * Admin 4/24/2025
 **/
public class Main {
    public static void main(String[] args) {
//        EntityManager em = EntityManagerUtil.getEntityManager();


//        List<Quiz> list = QuizDAO.findAllQuizWithCategoryName();
//        list.forEach(x -> System.out.println(x.getTitle() + ": " + x.getCategory().getName()));

//        QuizDAO.findQuizWithHighScore().forEach(System.out::println);
//        QuizDAO.findQuizStartingWithA().forEach(System.out::println);

//        CategoryDAO.countQuizInEachCategory().forEach((k, v) -> System.out.println(k.getName() + ": " + v));
//        CategoryDAO.sumQuizScoreByCategory().forEach((k, v) -> System.out.println(k.getName() + ": " + v));
//        CategoryDAO.findCategoryWithLowestAverageScore().forEach((k, v) -> System.out.println(k.getName() + ": " + v));
        CategoryDAO.findCategoryWithLowestAverageScore().forEach((k, v) -> System.out.println(k.getName() + ": " + v));

    }
}
