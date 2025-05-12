package service.impl;

import dao.QuestionDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.Category;
import model.Question;
import model.enums.Level;
import util.JPAUtils;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 * Admin 5/10/2025
 **/
public class QuestionServiceImpl extends UnicastRemoteObject implements service.QuestionService {

    private QuestionDAO questionDAO;

    public QuestionServiceImpl() throws RemoteException {
        this.questionDAO = new QuestionDAO();
    }

    @Override
    public List<Question> listQuestionsByLevelAndCategory(String categoryName, Level questionLevel) throws RemoteException {
        return questionDAO.listQuestionsByLevelAndCategory(categoryName, questionLevel);
    }

    @Override
    public Question addQuestionToCategory(Question question, String categoryId) throws RemoteException {
        return questionDAO.addQuestionToCategory(question, categoryId);
    }


}
