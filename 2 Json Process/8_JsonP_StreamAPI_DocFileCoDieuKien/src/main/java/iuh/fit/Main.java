package iuh.fit;

import iuh.fit.model.Student;
import iuh.fit.util.JsonUtils;

import java.util.List;

/**
 * Admin 4/15/2025
 * ${DESCRIPTION}
 **/
public class Main {
    public static void main(String[] args) {
        List<Student> res = JsonUtils.listStudentsByClassName("Math", "json/classes.json");
        res.forEach(System.out::println);
        JsonUtils.writeStudentsToJson(res, "json/students.json");
    }
}