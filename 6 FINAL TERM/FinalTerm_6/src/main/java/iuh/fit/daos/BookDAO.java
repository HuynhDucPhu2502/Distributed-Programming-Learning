package iuh.fit.daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import iuh.fit.models.Book;
import iuh.fit.models.Person;
import iuh.fit.models.Review;
import iuh.fit.utils.JPAUtil;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Admin 5/13/2025
 **/
public class BookDAO {

    public List<Book> listRatedBooks(String author, int rating) {

        try (EntityManager em = JPAUtil.getEntityManager()) {
            String jpql =
                    """
                    SELECT b 
                    FROM Book b 
                    JOIN b.reviews r
                    JOIN b.authors a  
                    WHERE a = :author AND r.rating >= :rating
                    """;

            TypedQuery<Book> query = em.createQuery(jpql, Book.class);
            query.setParameter("author", author);
            query.setParameter("rating", rating);


            return query.getResultList();
        }

    }


    public Map<String, Long> countBooksByAuthor() {

        try (EntityManager em = JPAUtil.getEntityManager()) {
            String jpql =
                    """
                    SELECT a, COUNT(bt)
                    FROM BookTranslation bt 
                    JOIN bt.authors a
                    GROUP BY a 
                    ORDER BY a  
                    """;

            TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);


            return query
                    .getResultList()
                    .stream()
                    .collect(Collectors.toMap(
                            obj -> (String) obj[0],
                            obj -> (Long) obj[1],
                            (v1, v2) -> v1,
                            LinkedHashMap::new
                    ));
        }
    }

    public boolean updateReviews(String isbn, String readerID, int rating, String comment) {

        try (EntityManager em = JPAUtil.getEntityManager()) {

            em.getTransaction().begin();

            Person person = em.find(Person.class, readerID);
            if (person == null) return false;

            Book book = em.find(Book.class, isbn);
            if (book == null) return false;

            if (rating < 1 || rating > 5) return false;

            if (comment.isBlank()) return false;

            Review review = new Review(person, book, rating, comment);
            em.persist(review);


            em.getTransaction().commit();

            return true;
        } catch (Exception e) {
            return false;
        }
    }



}
