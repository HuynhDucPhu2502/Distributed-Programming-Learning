package iuh.fit.daos.impl;

import iuh.fit.daos.StudentDAO;
import iuh.fit.models.Department;
import iuh.fit.models.Student;
import iuh.fit.utils.JPAUtil;
import jakarta.persistence.TypedQuery;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Admin 4/9/2025
 **/
public class StudentDAOImpl implements StudentDAO {

    @Override
    public List<Student> getAll() {
        try (var em = JPAUtil.getEntityManager()) {
            return em.createQuery("FROM Student", Student.class).getResultList();
        }
    }

    @Override
    public Map<Department, Long> getNumberOfStudentsByDepartment() {
        try (var em = JPAUtil.getEntityManager()) {
            TypedQuery<Object[]> query = em.createQuery("""
            SELECT c.department, COUNT(DISTINCT sg.student)
            FROM StudentGrade sg
            JOIN sg.course c
            GROUP BY c.department
            ORDER BY COUNT(DISTINCT sg.student) DESC
        """, Object[].class);

            List<Object[]> resultList = query.getResultList();

            return resultList.stream()
                    .collect(Collectors.toMap(
                            row -> (Department) row[0],
                            row -> (Long) row[1],
                            (a, b) -> a,
                            LinkedHashMap::new
                    ));
        }
    }

    @Override
    public Map<Student, Double> getAverageScoreOfStudents() {
        try (var em = JPAUtil.getEntityManager()) {
            TypedQuery<Object[]> query = em.createQuery("""
                SELECT s, AVG(sg.grade)
                  FROM Student s
                  LEFT JOIN s.studentGrades sg
                  GROUP BY s
            """, Object[].class);

            List<Object[]> results = query.getResultList();

            return results.stream()
                    .collect(Collectors.toMap(
                            row -> (Student) row[0],
                            row -> row[1] != null ? (Double) row[1] : 0.0,
                            (a, b) -> a,
                            LinkedHashMap::new
                    ));
        }
    }

    @Override
    public List<Student> listStudentsStudyingCourseWithHighestScore(String courseName) {
        try (var em = JPAUtil.getEntityManager()) {

            Double maxScore = em.createQuery("""
            SELECT MAX(sg.grade)
            FROM StudentGrade sg
            WHERE sg.course.title = :title AND sg.grade IS NOT NULL
        """, Double.class)
                    .setParameter("title", courseName)
                    .getSingleResult();

            if (maxScore == null) return List.of();

            return em.createQuery("""
            SELECT sg.student
            FROM StudentGrade sg
            WHERE sg.course.title = :title AND sg.grade = :max
        """, Student.class)
                    .setParameter("title", courseName)
                    .setParameter("max", maxScore)
                    .getResultList();
        }
    }


}
