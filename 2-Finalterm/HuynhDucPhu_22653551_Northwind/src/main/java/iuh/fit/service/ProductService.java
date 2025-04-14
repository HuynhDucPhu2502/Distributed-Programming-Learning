package iuh.fit.service;

import iuh.fit.model.Product;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Admin 4/14/2025
 **/
public interface ProductService extends GenericService<Product, Integer> {
    List<Product> listProductsWithTheHighestPrice() throws RemoteException;
    List<Product> listProductsNotBeenSold() throws RemoteException;
}
