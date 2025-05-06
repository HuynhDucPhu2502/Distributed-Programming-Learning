package service.implement;

import daos.DepartmentDAO;
import models.Department;
import service.DepartmentService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Map;

/**
 * Admin 5/5/2025
 **/


public class DepartmentServiceImpl extends UnicastRemoteObject implements DepartmentService {

    private final DepartmentDAO departmentDAO;

    public DepartmentServiceImpl() throws RemoteException {
        departmentDAO = new DepartmentDAO();
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
