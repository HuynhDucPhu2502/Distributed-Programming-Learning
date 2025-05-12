import dao.QuestionDAO;
import dao.QuizDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import model.Question;
import model.enums.Level;
import util.JPAUtils;

/**
 * Admin 5/10/2025
 **/
public class Main {
    public static void main(String[] args) {
//        EntityManager entityManager = Persistence
//                .createEntityManagerFactory("mariadb")
//                .createEntityManager();

        JPAUtils.getEntityManager();

        QuestionDAO questionDAO = new QuestionDAO();
//        questionDAO.listQuestionsByLevelAndCategory("mo", Level.HARD)
//                .forEach(System.out::println);

        Question question = new Question();
        question.setId("Q_22653551");
        question.setLevel(Level.EASY);

//        System.out.println(questionDAO.addQuestionToCategory(question, "C101"));


        QuizDAO quizDAO = new QuizDAO();
//        quizDAO.countQuestionsByLevelInQuiz("QZ108")
//                .forEach((k , v) -> System.out.println(k + ": " + v));




        JPAUtils.close();
    }
}
