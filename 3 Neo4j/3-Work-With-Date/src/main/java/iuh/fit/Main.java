package iuh.fit;

import iuh.fit.daos.StudentDAO;
import iuh.fit.models.Student;
import iuh.fit.utils.Neo4jMapper;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Admin 3/2/2025
 * ${DESCRIPTION}
 **///TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Student student = Student.builder()
                .id("1")
                .name("Nguyen Van A")
                .dob(LocalDateTime.of(2000, 1, 1, 0, 0))
                .build();
//
//        StudentDAO.addStudent(student);
//        StudentDAO.listStudent().forEach(System.out::println);

        student.setDob(LocalDateTime.now());
        StudentDAO.updateStudent("1", student);
        StudentDAO.listStudent().forEach(System.out::println);
    }
}