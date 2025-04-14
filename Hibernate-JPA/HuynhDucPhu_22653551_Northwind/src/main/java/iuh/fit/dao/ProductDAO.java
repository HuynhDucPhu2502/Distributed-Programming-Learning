package iuh.fit.dao;

import iuh.fit.model.Product;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;

/**
 * Admin 4/14/2025
 **/
public class ProductDAO extends GenericDAO<Product, Integer> {
    public ProductDAO(Class<Product> clazz) {
        super(clazz);
    }

    public ProductDAO(EntityManager em, Class<Product> clazz) {
        super(em, clazz);
    }

    // Tìm sản phẩm với giá cao nhất
    public List<Product> listProductsWithTheHighestPrice() {
        String jpql =
                """
                SELECT p FROM Product p 
                WHERE p.listPrice = (SELECT max(p.listPrice) FROM Product p)
                """;

        return em.createQuery(jpql, Product.class).getResultList();
    }

//    public List<Product> listProductsNotBeenSold() {
//        String jpql =
//                """
//                SELECT p FROM Product p
//                WHERE p.id NOT IN (SELECT i.product.id FROM OrderItem i)
//                """;
//
//        return em.createQuery(jpql, Product.class).getResultList();
//    }

//    public List<Product> listProductsNotBeenSold() {
//        String jpql =
//                """
//                SELECT p FROM Product p
//                WHERE SIZE(p.items) = 0
//                """;
//
//        return em.createQuery(jpql, Product.class).getResultList();
//    }

    public List<Product> listProductsNotBeenSold() {
        String jpql =
                """
                SELECT p FROM Product p 
                LEFT JOIN OrderItem i ON p.id = i.product.id
                WHERE i.product.id IS NULL
                """;

        return em.createQuery(jpql, Product.class).getResultList();
    }


    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO(Product.class);
//        Product product = productDAO.findByID(1);
//        System.out.println(product);

//        List<Product> products = productDAO.listProductsWithTheHighestPrice();
//        products.forEach(System.out::println);

//        List<Product> products2 = productDAO.listProductsNotBeenSold();
//        products2.forEach(System.out::println);





    }


}
