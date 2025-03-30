package iuh.fit.dao;

import iuh.fit.model.Movie;
import iuh.fit.model.Person;
import iuh.fit.util.AppUtils;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.summary.ResultSummary;
import org.neo4j.driver.types.Node;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Admin 3/30/2025
 **/
public class MovieDAO {

    public List<Movie> listMoviesContainsName(String name) {
        return Collections.emptyList();
    }

    public boolean createMovie(Movie movie) {
        return false;
    }

    public List<Movie> listMoviesByActorAndReleased(String actorName, int released) {
        return Collections.emptyList();
    }

    public Map<String, Long> getNoOfMoviePerActorByReleasedRange(int from, int to) {
        return Collections.emptyMap();
    }

    public List<Person> listPersonByKeyword(String keyword) {
        return Collections.emptyList();
    }

}
