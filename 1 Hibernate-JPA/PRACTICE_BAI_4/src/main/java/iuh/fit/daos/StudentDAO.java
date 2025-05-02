package iuh.fit.daos;

import iuh.fit.models.Department;
import iuh.fit.models.Student;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

/**
 * Admin 4/9/2025
 **/
public interface StudentDAO extends Remote {
    List<Student> getAll() throws RemoteException;

    Map<Department, Long> getNumberOfStudentsByDepartment() throws RemoteException;

    Map<Student, Double> getAverageScoreOfStudents() throws RemoteException;

    List<Student> listStudentsStudyingCourseWithHighestScore(String courseName) throws RemoteException;
}
