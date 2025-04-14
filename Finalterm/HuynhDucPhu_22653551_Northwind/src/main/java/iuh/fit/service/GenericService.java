package iuh.fit.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Admin 4/14/2025
 **/
public interface GenericService<T, ID> extends Remote {
    T findByID(ID id) throws RemoteException;
    List<T> getAll() throws RemoteException;
    boolean save(T t) throws RemoteException;
    boolean update(T t) throws RemoteException;
}
