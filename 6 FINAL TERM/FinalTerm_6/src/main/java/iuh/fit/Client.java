package iuh.fit;

import iuh.fit.services.BookService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Admin 5/13/2025
 **/
public class Client {
    public static void main(String[] args) throws Exception {

        Registry registry = LocateRegistry.getRegistry("Admin-PC", 8080);

        BookService bookService = (BookService) registry.lookup("bookService");

        bookService.listRatedBooks("Dennis M. Ritchie", 4).forEach(System.out::println);

    }
}
