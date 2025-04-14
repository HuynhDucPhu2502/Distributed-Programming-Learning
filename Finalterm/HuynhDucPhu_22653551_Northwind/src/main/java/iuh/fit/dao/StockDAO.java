package iuh.fit.dao;

import iuh.fit.model.Stock;
import jakarta.persistence.EntityManager;

/**
 * Admin 4/14/2025
 **/
public class StockDAO extends GenericDAO<Stock, Stock.StockId> {
    public StockDAO(Class<Stock> clazz) {
        super(clazz);
    }

    public StockDAO(EntityManager em, Class<Stock> clazz) {
        super(em, clazz);
    }

    public static void main(String[] args) {

    }
}
