package services.impl;

import daos.ShowDAO;
import models.Show;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Admin 5/14/2025
 **/
public class ShowServiceImpl extends UnicastRemoteObject implements services.ShowService {

    private ShowDAO showDAO;

    public ShowServiceImpl() throws RemoteException {
        showDAO = new ShowDAO();
    }

    @Override
    public List<Show> listShowsByCurrentDateAndDirector(String director) throws RemoteException {
        return showDAO.listShowsByCurrentDateAndDirector(director);
    }

    @Override
    public boolean updateShowDateTime(String showId, LocalDateTime newShowDateTime) throws RemoteException {
        return showDAO.updateShowDateTime(showId, newShowDateTime);
    }


}
