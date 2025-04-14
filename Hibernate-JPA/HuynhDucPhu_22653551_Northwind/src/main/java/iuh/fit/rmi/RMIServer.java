package iuh.fit.rmi;

import iuh.fit.dao.ProductDAO;
import iuh.fit.model.Product;
import iuh.fit.service.ProductService;
import iuh.fit.service.impl.ProductServiceImpl;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.registry.LocateRegistry;

/**
 * Admin 4/14/2025
 **/
public class RMIServer {

    public static void main(String[] args) throws Exception {

        Context context = new InitialContext();
        LocateRegistry.createRegistry(8080);

        ProductDAO productDAO = new ProductDAO(Product.class);
        ProductService productService = new ProductServiceImpl(productDAO);

        context.bind("rmi://Admin-PC:8080/ProductService", productService);
        System.out.println("RMI server started");
    }

}
