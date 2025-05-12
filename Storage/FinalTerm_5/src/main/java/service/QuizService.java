package service;

import model.enums.Level;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

/**
 * Admin 5/10/2025
 **/
public interface QuizService extends Remote {
    Map<Level, Long> countQuestionsByLevelInQuiz(String quizId) throws RemoteException;
}
