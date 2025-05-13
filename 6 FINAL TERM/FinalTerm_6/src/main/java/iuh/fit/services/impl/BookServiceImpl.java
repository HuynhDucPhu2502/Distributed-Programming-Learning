package iuh.fit.services.impl;

import iuh.fit.daos.BookDAO;
import iuh.fit.models.Book;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Map;

/**
 * Admin 5/13/2025
 **/
public class BookServiceImpl extends UnicastRemoteObject implements iuh.fit.services.BookService {

    private BookDAO bookDAO;

    public BookServiceImpl() throws RemoteException {
        bookDAO = new BookDAO();
    }

    @Override
    public List<Book> listRatedBooks(String author, int rating) throws RemoteException {
        return bookDAO.listRatedBooks(author, rating);
    }

    @Override
    public Map<String, Long> countBooksByAuthor() throws RemoteException {
        return bookDAO.countBooksByAuthor();
    }

    @Override
    public boolean updateReviews(String isbn, String readerID, int rating, String comment) throws RemoteException {
        return bookDAO.updateReviews(isbn, readerID, rating, comment);
    }
}
