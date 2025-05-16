/**
 * Admin 5/16/2025
 **/

import dao.QuestionDAO;
import jakarta.persistence.EntityManager;
import model.Question;
import model.enums.Level;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import util.JPAUtils;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class QuestionDAOTest {

    private QuestionDAO questionDAO;

    @BeforeAll
     void startup() {
        questionDAO = new QuestionDAO();
    }

    @AfterAll
     void teardown() {
        questionDAO = null;
    }

    // 3 Phương thức
    // 1 phương thức / 2 hàm:
    // + Hàm test dữ liệu hợp lý
    // + Hàm test dữ liệu không hợp lý

    @Test
    void listQuestionsByLevelAndCategoryTest() {
        List<Question> questions = questionDAO
                .listQuestionsByLevelAndCategory("mo", Level.EASY);
        Question question = questions.get(0);

        assertEquals(4, questions.size());
        assertEquals("Q131", question.getId());
    }

    @Test
    void listQuestionsByLevelAndCategoryNullTest() {
        List<Question> questions = questionDAO
                .listQuestionsByLevelAndCategory("Huynh Duc Phu", Level.EASY);

        assertEquals(0, questions.size());
    }

    @Test
    void countQuestionsByLevelInQuizTest() {
        Map<Level, Long> map = questionDAO.countQuestionsByLevelInQuiz("QZ108");

        assertEquals(3, map.size());
        assertEquals(4, map.get(Level.HARD));
    }

    @Test
    void countQuestionsByLevelInQuizNullTest() {
        Map<Level, Long> map = questionDAO.countQuestionsByLevelInQuiz("Huynh Duc Phu");

        assertEquals(0, map.size());
    }

    @Test
    void addQuestionToCategoryTest() {
        Question question = new Question();
        question.setId("TestQuestion01");
        question.setQuestionText("Huynh Duc Phu");

        assertEquals(question, questionDAO.addQuestionToCategory(question, "C101"));

        EntityManager em = JPAUtils.getEntityManager();
        Question question2 = em.find(Question.class, "TestQuestion01");

        assertNotNull(question2);

        em.getTransaction().begin();
        em.remove(question2);
        em.getTransaction().commit();
    }

    @Test
    void addQuestionToCategoryNullTest() {
        Question question = new Question();
        question.setId("TestQuestion01");
        question.setQuestionText("Huynh Duc Phu");

        assertNull(questionDAO.addQuestionToCategory(question, "Huynh Duc Phu"));
    }



}
