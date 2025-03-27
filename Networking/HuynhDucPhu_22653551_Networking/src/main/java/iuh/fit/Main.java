package iuh.fit;

import iuh.fit.dao.SupplierDAO;
import iuh.fit.dao.SupplierDAOImpl;
import iuh.fit.model.Supplier;

public class Main {
    public static void main(String[] args) {

        SupplierDAO supplierDAO = new SupplierDAOImpl();
        Supplier supplier = supplierDAO.findById(1);
        System.out.println(supplier);

    }
}