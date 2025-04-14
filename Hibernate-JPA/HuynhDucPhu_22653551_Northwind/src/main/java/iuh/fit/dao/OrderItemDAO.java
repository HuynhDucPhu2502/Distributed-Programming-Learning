package iuh.fit.dao;

import iuh.fit.model.Order;
import iuh.fit.model.OrderItem;
import iuh.fit.model.Product;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;

/**
 * Admin 4/14/2025
 **/
public class OrderItemDAO extends GenericDAO<OrderItem, OrderItem.OrderItemId> {
    public OrderItemDAO(Class<OrderItem> clazz) {
        super(clazz);
    }

    public OrderItemDAO(EntityManager em, Class<OrderItem> clazz) {
        super(em, clazz);
    }

    public Double calcTotalPriceOnCertainDate(LocalDate date) {
        String jpql =
                """
                SELECT SUM((i.quantity * i.product.listPrice) * (1 - i.discount))
                FROM OrderItem i
                WHERE i.order.orderDate = :date
                """;

        return em.createQuery(jpql, Double.class)
                .setParameter("date", date)
                .getSingleResult();

    }

    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO(Product.class);
        OrderDAO orderDAO = new OrderDAO(Order.class);
        OrderItemDAO orderItemDAO = new OrderItemDAO(OrderItem.class);

//        Product product = productDAO.findByID(4);
//        Order order = orderDAO.findByID(1);
//
//        OrderItem.OrderItemId id = new OrderItem.OrderItemId(order, product);
//        OrderItem orderItemd = orderItemDAO.findByID(id);
//        System.out.println(orderItemd);


        System.out.println(orderItemDAO.calcTotalPriceOnCertainDate(LocalDate.of(2016, 1, 14)));


    }
}
