package iuh.fit.dao;

import iuh.fit.model.Order;
import jakarta.persistence.EntityManager;

/**
 * Admin 4/14/2025
 **/
public class OrderDAO extends GenericDAO<Order, Integer> {
    public OrderDAO(Class<Order> clazz) {
        super(clazz);
    }

    public OrderDAO(EntityManager em, Class<Order> clazz) {
        super(em, clazz);
    }

    public static void main(String[] args) {
        OrderDAO orderDAO = new OrderDAO(Order.class);
        orderDAO.getAll().forEach(System.out::println);
    }
}
