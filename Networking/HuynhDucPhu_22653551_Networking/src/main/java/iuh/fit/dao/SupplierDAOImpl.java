package iuh.fit.dao;

import iuh.fit.model.Supplier;
import iuh.fit.util.MyJson;

import java.util.List;

public class SupplierDAOImpl implements SupplierDAO{

    private List<Supplier> suppliers;

    public SupplierDAOImpl(){
        suppliers = MyJson.loadDataFromJson("json/suppliers.json", Supplier.class);
    }

    @Override
    public void insert(Supplier supplier) {

    }

    @Override
    public void update(Supplier supplier) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Supplier findById(int id) {
        return suppliers.stream()
                .filter(s -> s.getSupplierID() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Supplier> findAll() {
        return this.getSuppliers();
    }

    public List<Supplier> getSuppliers() {
        return suppliers;
    }
}
