package iuh.fit;

import iuh.fit.daos.StudentDAO;
import iuh.fit.utils.JPAUtil;

/**
 * Admin 2/11/2025
 * ${DESCRIPTION}
 **///TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        StudentDAO.getAll().forEach(System.out::println);
//        StudentDAO.getNumberOfStudentsByDepartment().forEach((k, v) -> System.out.println(k.getName() + ": " + v));
//        StudentDAO.getAverageScoreOfStudents().forEach((k, v) -> System.out.println(k.getName() + ": " + v));
//        DepartmentDAO.listDepartmentsWithoutStudents().forEach(System.out::println);
        StudentDAO.listStudentsStudyingCourseWithHighestScore("Distributed Programming with Java Technology")
                .forEach(s -> System.out.println(s.getId() + " - " + s.getLastName()));

        JPAUtil.close();
    }
}