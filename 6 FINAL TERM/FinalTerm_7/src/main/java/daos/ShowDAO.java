package daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import models.Movie;
import models.Show;
import utils.JPAUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Admin 5/14/2025
 **/
public class ShowDAO {

    public List<Show> listShowsByCurrentDateAndDirector(String director) {

        try (EntityManager em = JPAUtil.getEntityManager()) {
            LocalDateTime currentDay = LocalDate.now().atStartOfDay();
            LocalDateTime nextDay = currentDay.plusDays(1);

            String jpql =
                    """
                    SELECT s 
                    FROM Show s 
                    JOIN s.movie m 
                    WHERE m.director = :director 
                        AND s.showDateTime >= :currentDay  
                        AND s.showDateTime < :nextDay
                    """;

            TypedQuery<Show> query = em.createQuery(jpql, Show.class);
            query.setParameter("director", director);
            query.setParameter("currentDay", currentDay);
            query.setParameter("nextDay", nextDay);

            return query.getResultList();
        }
    }

    public boolean updateShowDateTime(String showId, LocalDateTime newShowDateTime) {

        try (EntityManager em = JPAUtil.getEntityManager()) {
            em.getTransaction().begin();

            Show show = em.find(Show.class, showId);

            if (show == null) {
                em.getTransaction().rollback();
                return false;
            }

            String jpql =
                    """
                    SELECT COUNT(t) 
                    FROM Ticket t 
                    JOIN t.show s 
                    WHERE s.id = :showId
                    """;
            TypedQuery<Long> query = em
                    .createQuery(jpql, Long.class)
                    .setParameter("showId", showId);
            Long count = query.getSingleResult();

            if (count != 0) {
                em.getTransaction().rollback();
                return false;
            }

            show.setShowDateTime(newShowDateTime);
            em.merge(show);


            em.getTransaction().commit();

            return true;
        }
    }

    public boolean addMovie(Movie movie) {

        if (!movie.getId().matches("M\\d{3,}"))
            return false;

        if (movie.getDuration() <= 0)
            return false;

        try (EntityManager em = JPAUtil.getEntityManager()) {
            em.getTransaction().begin();
            em.persist(movie);
            em.getTransaction().commit();
        }

        return true;
    }


}
