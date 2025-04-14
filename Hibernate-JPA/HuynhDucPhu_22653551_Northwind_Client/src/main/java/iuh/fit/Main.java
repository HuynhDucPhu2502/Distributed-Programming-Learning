package iuh.fit;

import iuh.fit.service.ProductService;

import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * Admin 4/14/2025
 * ${DESCRIPTION}
 **/
public class Main {
    public static void main(String[] args) throws Exception {
        Context context = new InitialContext();


        ProductService productService = (ProductService) context.lookup("rmi://Admin-PC:8080/ProductService");


        productService.getAll().forEach(System.out::println);
    }
}