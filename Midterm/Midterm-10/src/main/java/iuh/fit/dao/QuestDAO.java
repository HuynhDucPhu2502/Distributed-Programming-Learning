package iuh.fit.dao;

import iuh.fit.model.Level;
import iuh.fit.model.Quest;
import iuh.fit.util.AppUtils;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.types.Node;

import java.util.*;
import java.util.stream.Collectors;

/**
 *  Admin 4/1/2025
 *  
**/
public class QuestDAO {
    public Map<Level, Long> countQuestLevel(String categoryName) {
        String query =
                """
                MATCH (q:Question)-[r:BELONGS_TO]->(c:Category)
                WHERE c.name = $name
                RETURN q.level as level, count(q) as total
                ORDER BY total ASC
                """;
        Map<String, Object> params = Map.of(
                "name", categoryName
        );

        try (Session session = AppUtils.getSession()) {
            return session.executeRead(tx -> {
                Result result = tx.run(query, params);

                return result
                        .stream()
                        .collect(Collectors.toMap(
                                r -> Level.fromString(r.get("level").asString()),
                                r -> r.get("total").asLong(),
                                (v1, v2) -> v1,
                                LinkedHashMap::new
                        ));
            });
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyMap();
        }

    }

    public Set<Quest> getQuestSortByPoint(String categoryName) {
        String query =
                """
                MATCH (q:Question)-[r:BELONGS_TO]->(c:Category)
                WHERE c.name = $name
                RETURN q
                ORDER BY q.points DESC
                """;
        Map<String, Object> params = Map.of(
                "name", categoryName
        );

        try (Session session = AppUtils.getSession()) {
            return session.executeRead(tx -> {
                Result result = tx.run(query, params);

                return result
                        .stream()
                        .map(r -> {
                            Node node = r.get("q").asNode();

                            return new Quest(
                                    node.get("title").asString(),
                                    node.get("id").asString(),
                                    Level.fromString(node.get("level").asString()),
                                    Integer.parseInt(node.get("points").asString()),
                                    Integer.parseInt(node.get("count").asString())
                            );
                        })
                        .collect(Collectors.toCollection(LinkedHashSet::new));
            });


        } catch (Exception e) {
            e.printStackTrace();
            return new LinkedHashSet<>();
        }
    }


    public void Test() {
        String query =
                """
                """;
        Map<String, Object> params = Map.of(

        );

        try (Session session = AppUtils.getSession()) {


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
