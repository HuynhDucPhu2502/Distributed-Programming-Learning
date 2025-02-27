package iuh.fit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import iuh.fit.daos.CourseDAO;
import iuh.fit.models.Course;

/**
 * Admin 2/27/2025
 * ${DESCRIPTION}
 **///TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws JsonProcessingException {
//        CourseDAO.listCourses(10, 0).forEach(System.out::println);
//
        Course course = Course
                .builder()
                .courseId("456")
                .name("HDP")
                .hours(10)
                .departmentId("123")
                .build();
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String json = objectMapper.writeValueAsString(course).replaceAll("\"([A-Za-z0-9_]+)\":", "$1:");
//        System.out.println(json);
        System.out.println(CourseDAO.addCourse(course));

//        CourseDAO.listCourses(100, 0).forEach(System.out::println);
//        System.out.println(CourseDAO.deleteCourse("456"));

        Course newCourse = Course.builder()
                .courseId("456")
                .name("SPRING BOOT RESTFUL API")
                .build();
        CourseDAO.updateCourse(newCourse);

    }
}