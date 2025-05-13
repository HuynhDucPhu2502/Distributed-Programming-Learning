package iuh.fit;

import iuh.fit.daos.BookDAO;
import iuh.fit.utils.JPAUtil;

/**
 * Admin 5/13/2025
 **/
public class Main {
    public static void main(String[] args) {
//        EntityManager em = Persistence
//                .createEntityManagerFactory("mariadb")
//                .createEntityManager();

        JPAUtil.getEntityManager();

        BookDAO bookDAO = new BookDAO();
//        bookDAO.listRatedBooks("Dennis M. Ritchie", 4).forEach(System.out::println);
//        bookDAO.countBooksByAuthor()
//                .forEach((k, v) -> System.out.println(k + ": " + v));

//        System.out.println(bookDAO.updateReviews(
//                "9781491950357",
//                "8",
//                4,
//                "Qua Tuyet Voi!!")
//        );


    }
}
