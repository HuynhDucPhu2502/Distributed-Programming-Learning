package iuh.fit;

import iuh.fit.daos.CourseDao;
import iuh.fit.daos.DepartmentDao;
import iuh.fit.daos.StudentDao;
import iuh.fit.models.Course;
import org.neo4j.driver.Driver;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Driver driver = AppUtils.getDriver();
        CourseDao courseDao = new CourseDao(driver, "hdpdb");
        StudentDao studentDao = new StudentDao(driver, "hdpdb");
        DepartmentDao departmentDao = new DepartmentDao(driver, "hdpdb");
//        System.out.println(courseDao.listCourses());
//        studentDao.enrollCourse("33", "MA301");
//        studentDao.unenrollCourse("33", "MA301");
//        studentDao.updateEnrollment("33", "MA301", 10);
//        departmentDao.searchDepartment("Carson").forEach(System.out::println);
        departmentDao.updateDateDepartment();
    }
}