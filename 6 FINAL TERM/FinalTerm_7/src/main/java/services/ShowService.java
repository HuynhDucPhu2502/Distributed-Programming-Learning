package services;

import models.Show;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Admin 5/14/2025
 **/
public interface ShowService extends Remote {
    List<Show> listShowsByCurrentDateAndDirector(String director) throws RemoteException;

    boolean updateShowDateTime(String showId, LocalDateTime newShowDateTime) throws RemoteException;
}
