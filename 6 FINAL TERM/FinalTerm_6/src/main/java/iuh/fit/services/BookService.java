package iuh.fit.services;

import iuh.fit.models.Book;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

/**
 * Admin 5/13/2025
 **/
public interface BookService extends Remote {
    List<Book> listRatedBooks(String author, int rating) throws RemoteException;

    Map<String, Long> countBooksByAuthor() throws RemoteException;

    boolean updateReviews(String isbn, String readerID, int rating, String comment) throws RemoteException;
}
