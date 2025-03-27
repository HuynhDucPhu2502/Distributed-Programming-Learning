package iuh.fit.dao;


import iuh.fit.model.Supplier;

import java.util.List;

public interface SupplierDAO  {
    void insert(Supplier supplier);
    void update(Supplier supplier);
    void delete(int id);
    Supplier findById(int id);
    List<Supplier> findAll();
}