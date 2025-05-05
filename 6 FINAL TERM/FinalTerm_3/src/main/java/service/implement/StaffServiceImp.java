package service.implement;

import daos.StaffDAO;
import models.Staff;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 * Admin 5/5/2025
 **/
public class StaffServiceImp extends UnicastRemoteObject implements service.StaffService {
    private final StaffDAO staffDAO;

    public StaffServiceImp() throws RemoteException {
        staffDAO = new StaffDAO();
    }

    @Override
    public List<Staff> findStaffByAgeBetween(int minAge, int maxAge) throws RemoteException {
        return staffDAO.findStaffByAgeBetween(minAge, maxAge);
    }

    @Override
    public List<Staff> findStaffByPhone(String phone) throws RemoteException {
        return staffDAO.findStaffByPhone(phone);
    }
}
