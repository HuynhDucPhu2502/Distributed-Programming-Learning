package service;

import models.Staff;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *  Admin 5/5/2025
 *  
**/public interface StaffService extends Remote {
    List<Staff> findStaffByAgeBetween(int minAge, int maxAge) throws RemoteException;

    List<Staff> findStaffByPhone(String phone) throws RemoteException;
}
