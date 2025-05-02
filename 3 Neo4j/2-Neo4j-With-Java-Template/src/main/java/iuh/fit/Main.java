package iuh.fit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import iuh.fit.daos.CourseDAO;
import iuh.fit.daos.DepartmentDAO;
import iuh.fit.daos.StudentDAO;
import iuh.fit.models.Course;
import iuh.fit.models.Enrollment;
import iuh.fit.models.Student;
import iuh.fit.utils.Neo4jMapper;

/**
 * Admin 2/27/2025
 * ${DESCRIPTION}
 **///TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws JsonProcessingException {
//        CourseDAO.listCourses(10, 0).forEach(System.out::println);
//
//        Course course = Course
//                .builder()
//                .courseId("456")
//                .name("HDP")
//                .hours(10)
//                .departmentId("123")
//                .build();
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String json = objectMapper.writeValueAsString(course).replaceAll("\"([A-Za-z0-9_]+)\":", "$1:");
//        System.out.println(json);
//        System.out.println(CourseDAO.addCourse(course));

//        CourseDAO.listCourses(100, 0).forEach(System.out::println);
//        System.out.println(CourseDAO.deleteCourse("456"));

//        Course newCourse = Course.builder()
//                .courseId("456")
//                .name("SPRING BOOT RESTFUL API")
//                .build();
//        CourseDAO.updateCourse(newCourse);

//        DepartmentDAO.listDepartment(100, 0).forEach(System.out::println);

//        System.out.println(StudentDAO.enrollCourse("12", "IE102", 5.0));;

//        System.out.println(StudentDAO.unEnrollCourse("12", "IE102"));
//        Student student = Student.builder()
//                .name("Admin")
//                .gpa(3.0)
//                .build();
//        System.out.println(StudentDAO.updateStudent(student, "3sfafsa3"));
//        StudentDAO.listStudent(100, 0).forEach(System.out::println);

//        System.out.println(StudentDAO.findStudentById("33"));
//        System.out.println(DepartmentDAO.findDepartmenById("Math"));
//        System.out.println(DepartmentDAO.updateDepartmentName("Math", "Mathematics"));
//        System.out.println(DepartmentDAO.findDepartmenById("Math"));
//        System.out.println(DepartmentDAO.getAllDepartmentDean());
//        System.out.println(DepartmentDAO.getDeanByDepartmentId("Math"));
//        System.out.println(CourseDAO.getAllCourseByDepartmentId("Math"));
//        System.out.println(StudentDAO.getStudentNameEnrolledCourse("CS101"));
//        System.out.println(DepartmentDAO.getNumberOfStudentByDepartment());

//        System.out.println(DepartmentDAO.getDepartmentDeanWithMostStudent());
            StudentDAO.getStudentAboveCertainGPASortAsc(1).forEach(System.out::println);
    }
}