package iuh.fit.service.impl;

import iuh.fit.dao.GenericDAO;
import iuh.fit.service.GenericService;
import org.yaml.snakeyaml.events.Event;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 * Admin 4/14/2025
 **/
public abstract class GenericServiceImpl<T, ID>
        extends UnicastRemoteObject
        implements GenericService<T, ID> {

    protected GenericDAO<T, ID> genericDAO;

    public GenericServiceImpl(GenericDAO<T, ID> genericDAO) throws RemoteException {
        this.genericDAO = genericDAO;
    }

    @Override
    public T findByID(ID id) throws RemoteException {
        return genericDAO.findByID(id);
    }

    @Override
    public List<T> getAll() throws RemoteException {
        return genericDAO.getAll();
    }

    @Override
    public boolean save(T t) throws RemoteException {
        return genericDAO.save(t);
    }

    @Override
    public boolean update(T t) throws RemoteException {
        return genericDAO.update(t);
    }
}
