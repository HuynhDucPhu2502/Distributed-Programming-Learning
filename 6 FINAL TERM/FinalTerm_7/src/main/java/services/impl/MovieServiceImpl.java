package services.impl;

import daos.MovieDAO;
import models.Movie;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Admin 5/14/2025
 **/
public class MovieServiceImpl extends UnicastRemoteObject implements services.MovieService {

    private MovieDAO movieDAO;

    public MovieServiceImpl() throws RemoteException {
        movieDAO = new MovieDAO();
    }

    @Override
    public boolean addMovie(Movie movie) throws RemoteException {
        return movieDAO.addMovie(movie);
    }
}
