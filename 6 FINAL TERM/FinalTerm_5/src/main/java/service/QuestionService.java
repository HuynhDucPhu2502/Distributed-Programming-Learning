package service;

import model.Question;
import model.enums.Level;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

/**
 * Admin 5/10/2025
 **/
public interface QuestionService extends Remote {
    List<Question> listQuestionsByLevelAndCategory(String categoryName, Level questionLevel) throws RemoteException;

    Map<Level, Long> countQuestionsByLevelInQuiz(String quizId) throws RemoteException;

    Question addQuestionToCategory(Question question, String categoryId) throws RemoteException;
}
