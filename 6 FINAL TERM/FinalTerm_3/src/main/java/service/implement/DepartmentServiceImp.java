package service.implement;

import daos.DepartmentDAO;
import models.Department;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Map;

/**
 * Admin 5/5/2025
 **/
public class DepartmentServiceImp extends UnicastRemoteObject implements service.DepartmentService {

    private final DepartmentDAO departmentDAO;

    public DepartmentServiceImp() throws RemoteException {
        this.departmentDAO = new DepartmentDAO();
    }

    @Override
    public Map<Department, Long> countStaffByDepartment() throws RemoteException {
        return departmentDAO.countStaffByDepartment();
    }

    @Override
    public List<Department> findDepartmentWithAvgAgeGreaterThan(int age) throws RemoteException {
        return departmentDAO.findDepartmentWithAvgAgeGreaterThan(age);
    }
}
