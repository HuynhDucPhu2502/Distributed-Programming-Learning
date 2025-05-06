package devtools;

import daos.DepartmentDAO;
import daos.ProjectDAO;
import daos.StaffDAO;
import utils.EntityManagerUtil;

/**
 * Admin 5/3/2025
 **/
public class Main {
    public static void main(String[] args) {
//        EntityManager em = Persistence
//                .createEntityManagerFactory("mariadb").createEntityManager();


        StaffDAO staffDAO = new StaffDAO();
//        staffDAO.findStaffByNameKeyword("Jane").forEach(System.out::println);
//        staffDAO.findStaffByAgeBetween(20, 25).forEach(System.out::println);
//        staffDAO.findStaffWithoutProject().forEach(System.out::println);
//        staffDAO.findStaffByPhone("(954) 359-9352").forEach(System.out::println);
//        staffDAO.findStaffInProjectWithMaxBudget().forEach(System.out::println);
//        staffDAO.findStaffNotJoinLowBudgetProject(50000).forEach(System.out::println);

        ProjectDAO projectDAO = new ProjectDAO();
//        projectDAO.findProjectByMinBudget(40000).forEach(System.out::println);
//        projectDAO.findProjectHasStaffs().forEach(System.out::println);
//        projectDAO.findProjectsHasMoreStaffThanAverage().forEach(System.out::println);

        DepartmentDAO departmentDAO = new DepartmentDAO();
//        departmentDAO.findDepartmentHasMoreThan3Staffs().forEach(System.out::println);
//        departmentDAO.countStaffByDepartment()
//                .forEach((k, v) -> System.out.println(k.getName() + ": " + v));
//        departmentDAO.findDepartmentHasMoreStaffThanDepartment("D2").forEach(System.out::println);
//        departmentDAO.findDepartmentWithAvgAgeGreaterThan(30).forEach(System.out::println);





        EntityManagerUtil.close();
    }
}
