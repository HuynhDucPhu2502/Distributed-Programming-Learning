package iuh.fit;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Admin 3/31/2025
 **/
public interface ICal extends Remote {
    int sum(int a, int b) throws RemoteException;
    int sub(int a, int b) throws RemoteException;
}
