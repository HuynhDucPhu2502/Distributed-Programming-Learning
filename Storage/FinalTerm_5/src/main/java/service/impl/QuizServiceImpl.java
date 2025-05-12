package service.impl;

import dao.QuizDAO;
import model.enums.Level;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;

/**
 * Admin 5/10/2025
 **/
public class QuizServiceImpl extends UnicastRemoteObject implements service.QuizService {

    private QuizDAO quizDAO;

    public QuizServiceImpl() throws RemoteException {
        quizDAO = new QuizDAO();
    }

    @Override
    public Map<Level, Long> countQuestionsByLevelInQuiz(String quizId) throws RemoteException {
        return quizDAO.countQuestionsByLevelInQuiz(quizId);
    }
}
