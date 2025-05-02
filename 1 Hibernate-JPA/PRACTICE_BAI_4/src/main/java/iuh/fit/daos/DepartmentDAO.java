package iuh.fit.daos;

import iuh.fit.models.Department;

import java.rmi.Remote;
import java.util.List;

/**
 * Admin 4/9/2025
 **/
public interface DepartmentDAO extends Remote {
    List<Department> listDepartmentsWithoutStudents();
}
