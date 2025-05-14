import daos.MovieDAO;
import daos.ShowDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import models.Movie;

import java.time.LocalDateTime;

/**
 * Admin 5/14/2025
 **/
public class Main {
    public static void main(String[] args) {
//        EntityManager em = Persistence
//                .createEntityManagerFactory("mariadb")
//                .createEntityManager();

        ShowDAO showDAO = new ShowDAO();
        MovieDAO movieDAO = new MovieDAO();

//        showDAO.listShowsByCurrentDateAndDirector("Anthony Russo")
//                .forEach(System.out::println);

//        System.out.println(showDAO.updateShowDateTime("s016", LocalDateTime.now().minusDays(5)));

//        Movie movie = new Movie();
//        movie.setId("M069");
//        movie.setDuration(100);
//        System.out.println(movieDAO.addMovie(movie));
    }
}
