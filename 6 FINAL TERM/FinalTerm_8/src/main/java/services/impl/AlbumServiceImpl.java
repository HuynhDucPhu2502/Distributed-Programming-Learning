package services.impl;

import daos.AlbumDAO;
import models.Album;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Map;

/**
 * Admin 5/16/2025
 **/
public class AlbumServiceImpl extends UnicastRemoteObject implements services.AlbumService {

    private AlbumDAO albumDAO;

    public AlbumServiceImpl() throws RemoteException {
        albumDAO = new AlbumDAO();
    }

    @Override
    public boolean updatePriceOfAlbum(String id, double newPrice) throws RemoteException {
        return albumDAO.updatePriceOfAlbum(id, newPrice);
    }

    @Override
    public List<Album> listAlbumByGenre(String genreName, int releaseYear) throws RemoteException {
        return albumDAO.listAlbumByGenre(genreName, releaseYear);
    }

    @Override
    public Map<String, Long> getNumberOfAlbumsByGenre() throws RemoteException {
        return albumDAO.getNumberOfAlbumsByGenre();
    }
}
