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
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Admin 3/30/2025
 **/
public class MovieDAO {

    public List<Movie> listMoviesContainsName(String name) {
       String query =
               """
               MATCH (n:Movie)
               WHERE n.title CONTAINS $name
               RETURN n
               """;
       Map<String, Object> params = Map.of("name", name);

       try (Session session = AppUtils.getSession()) {
           return session.executeRead(tx -> {
               Result result = tx.run(query, params);

               return result
                       .stream()
                       .map(r -> {
                           Node node = r.get("n").asNode();

                           return Movie
                                   .builder()
                                   .title(node.get("title").asString())
                                   .tagline(node.get("tagline").asString())
                                   .released(node.get("released").asInt())
                                   .build();

                       })
                       .toList();
           });
       }

    }

    public boolean createMovie(Movie movie) {
        String query =
                """
                CREATE (m:Movie)
                SET m.title = $title, m.tagline = $tagline, m.released = $released
                """;
        Map<String, Object> params = Map.of(
                "title", movie.getTitle(),
                "tagline", movie.getTagline(),
                "released", movie.getReleased()
        );

        try (Session session = AppUtils.getSession()) {
            return session.executeWrite(tx -> {
                ResultSummary resultSummary = tx.run(query, params).consume();

                return resultSummary.counters().nodesCreated() > 0;
            });

        }
    }

    public List<Movie> listMoviesByActorAndReleased(String actorName, int released) {
        String query =
                """
                MATCH (p:Person)-[r:ACTED_IN]->(m:Movie)
                WHERE m.released = $released AND  p.name = $actorName
                RETURN m
                """;
        Map<String, Object> params = Map.of(
                "released", released,
                "actorName", actorName
        );

        try (Session session = AppUtils.getSession()) {
            return session.executeRead(tx -> {
                Result result = tx.run(query, params);

                return result
                        .stream()
                        .map(r -> {
                            Node node = r.get("m").asNode();

                            return Movie
                                    .builder()
                                    .title(node.get("title").asString())
                                    .tagline(node.get("tagline").asString())
                                    .released(node.get("released").asInt())
                                    .build();

                        })
                        .toList();
            });
        }




    }

    public Map<String, Long> getNoOfMoviePerActorByReleasedRange(int from, int to) {
        String query =
                """
                MATCH (p:Person)-[r:ACTED_IN]->(m:Movie)
                WHERE m.released >= $from AND m.released <= $to
                RETURN p.name as name, count(m) as total
                """;
        Map<String, Object> params = Map.of(
                "from", from,
                "to", to
        );

        try (Session session = AppUtils.getSession()) {
            return session.executeWrite(tx -> {
                Result result = tx.run(query, params);

                return result
                        .stream()
                        .collect(Collectors.toMap(
                                r -> r.get("name").asString(),
                                r -> r.get("total").asLong()
                        ));
            });

        }

    }

    public List<Person> listPersonByKeyword(String keyword) {
        String query =
                """
                CALL db.index.fulltext.queryNodes("actor_name_fti", $keyword) YIELD node
                RETURN node
                """;
        Map<String, Object> params = Map.of("keyword", keyword);

        try (Session session = AppUtils.getSession()) {
            return session.executeRead(tx -> {
                Result result = tx.run(query, params);

                return result
                        .stream()
                        .map(r -> {
                            Node node = r.get("node").asNode();

                            return Person
                                    .builder()
                                    .name(node.get("name").asString())
                                    .born(node.get("born").asInt())
                                    .build();
                        })
                        .toList();

            });
        }



    }

}
