package services;

import models.Movie;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Admin 5/14/2025
 **/
public interface MovieService extends Remote {
    boolean addMovie(Movie movie) throws RemoteException;
}
