package services;

import models.Album;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

/**
 * Admin 5/16/2025
 **/
public interface AlbumService extends Remote {
    boolean updatePriceOfAlbum(String id, double newPrice) throws RemoteException;

    List<Album> listAlbumByGenre(String genreName, int releaseYear) throws RemoteException;

    Map<String, Long> getNumberOfAlbumsByGenre() throws RemoteException;
}
