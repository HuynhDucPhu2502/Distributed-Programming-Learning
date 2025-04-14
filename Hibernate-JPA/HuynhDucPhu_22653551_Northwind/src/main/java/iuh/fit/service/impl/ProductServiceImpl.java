package iuh.fit.service.impl;

import iuh.fit.dao.GenericDAO;
import iuh.fit.dao.ProductDAO;
import iuh.fit.model.Product;
import iuh.fit.service.ProductService;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Admin 4/14/2025
 **/
public class ProductServiceImpl
        extends GenericServiceImpl<Product, Integer>
        implements ProductService {

    private ProductDAO productDAO;

    public ProductServiceImpl(ProductDAO productDAO) throws RemoteException {
        super(productDAO);
        this.productDAO = productDAO;
    }

    @Override
    public List<Product> listProductsWithTheHighestPrice() throws RemoteException {
        return productDAO.listProductsWithTheHighestPrice();
    }

    @Override
    public List<Product> listProductsNotBeenSold() throws RemoteException {
        return productDAO.listProductsNotBeenSold();
    }
}
