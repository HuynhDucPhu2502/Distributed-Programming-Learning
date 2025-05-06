package service;

import models.Department;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

/**
 * Admin 5/5/2025
 **/
public interface DepartmentService extends Remote {
    Map<Department, Long> countStaffByDepartment() throws RemoteException;

    List<Department> findDepartmentWithAvgAgeGreaterThan(int age) throws RemoteException;
}
