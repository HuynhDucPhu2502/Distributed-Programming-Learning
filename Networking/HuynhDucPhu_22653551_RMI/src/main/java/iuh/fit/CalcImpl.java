package iuh.fit;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Admin 3/31/2025
 **/
public class CalcImpl extends UnicastRemoteObject implements ICal {

    public CalcImpl() throws RemoteException {
        super();
    }

    @Override
    public int sum(int a, int b) throws RemoteException {
        return a + b;
    }

    @Override
    public int sub(int a, int b) throws RemoteException {
        return a - b;
    }
}
