package daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import models.Album;
import utils.JPAUtil;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Admin 5/16/2025
 **/
public class AlbumDAO {

    public boolean updatePriceOfAlbum(String id, double newPrice) {

        try (EntityManager em = JPAUtil.getEntityManager()) {
            em.getTransaction().begin();

            Album album = em.find(Album.class, id);

            if (album == null) {
                em.getTransaction().rollback();
                return false;
            }

            album.setPrice(newPrice);
            em.merge(album);


            em.getTransaction().commit();
            return true;
        }

    }

    public List<Album> listAlbumByGenre(String genreName, int releaseYear) {

        try (EntityManager em = JPAUtil.getEntityManager()) {
            String jpql =
                    """
                    SELECT a 
                    FROM Album a 
                    JOIN a.genre g 
                    WHERE g.name LIKE CONCAT("%", :genreName ,"%")
                        AND a.yearOfRelease = :releaseYear
                    """;

            TypedQuery<Album> query = em
                    .createQuery(jpql, Album.class)
                    .setParameter("genreName", genreName)
                    .setParameter("releaseYear", releaseYear);


            return query.getResultList();
        }
    }

    public Map<String, Long> getNumberOfAlbumsByGenre() {

        try (EntityManager em = JPAUtil.getEntityManager()) {
            String jpql =
                    """
                    SELECT g.name, COUNT(a) 
                    FROM Album a 
                    JOIN a.genre g 
                    GROUP BY g.name 
                    ORDER BY g.name 
                    """;

            TypedQuery<Object[]> query = em
                    .createQuery(jpql, Object[].class);


            return query.getResultList()
                    .stream()
                    .collect(Collectors.toMap(
                            obj -> (String) obj[0],
                            obj -> (Long) obj[1],
                            (v1, v2) -> v1,
                            LinkedHashMap::new
                    ));
        }
    }



}
