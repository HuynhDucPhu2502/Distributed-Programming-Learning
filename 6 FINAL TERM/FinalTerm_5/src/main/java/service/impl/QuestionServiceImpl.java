package service.impl;

import dao.QuestionDAO;
import model.Question;
import model.enums.Level;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Map;

/**
 * Admin 5/10/2025
 **/
public class QuestionServiceImpl extends UnicastRemoteObject implements service.QuestionService {

    private QuestionDAO questionDAO;

    public QuestionServiceImpl() throws RemoteException {
        questionDAO = new QuestionDAO();
    }

    @Override
    public List<Question> listQuestionsByLevelAndCategory(String categoryName, Level questionLevel) throws RemoteException {
        return questionDAO.listQuestionsByLevelAndCategory(categoryName, questionLevel);
    }

    @Override
    public Map<Level, Long> countQuestionsByLevelInQuiz(String quizId) throws RemoteException {
        return questionDAO.countQuestionsByLevelInQuiz(quizId);
    }

    @Override
    public Question addQuestionToCategory(Question question, String categoryId) throws RemoteException {
        return questionDAO.addQuestionToCategory(question, categoryId);
    }


}
