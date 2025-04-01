package iuh.fit.dao;

import iuh.fit.model.Trainer;
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
 * Admin 3/31/2025
 **/
public class TrainerDAO {
    public Map<String,Long> getNoOfTrainersBySpecialty(String centerName) {
        String query =
                """
                MATCH (t:Trainer)-[r:BELONGS_TO]->(c:Center)
                WHERE c.name = $name
                RETURN t.specialty as specialty, count(t) as total
                """;
        Map<String, Object> params = Map.of(
                "name", centerName
        );

        try (Session session = AppUtils.getSession()) {
            return session.executeRead(tx -> {
                Result res = tx.run(query, params);

                return res
                        .stream()
                        .collect(Collectors.toMap(
                                r -> r.get("specialty").asString(),
                                r -> r.get("total").asLong()
                        ));
            });
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyMap();
        }
    }

    public boolean addTrainerToCenter(Trainer trainer, String centerName) {
        String query =
                """
                CREATE (t:Trainer)
                SET t.id = $id, t.name = $name, t.phone = $phone,
                t.specialty = $spec
                WITH t
                MATCH (c:Center)
                WHERE c.name = $centerName
                MERGE (t)-[r:BELONGS_TO]-(c)
                """;
        Map<String, Object> params = Map.of(
                "id", trainer.getId(),
                "name", trainer.getName(),
                "phone", trainer.getPhone(),
                "spec", trainer.getSpecialty(),
                "centerName", centerName
        );

        try (Session session = AppUtils.getSession()) {
            return session.executeWrite(tx -> {
                ResultSummary resultSummary = tx.run(query, params).consume();

                return resultSummary.counters().nodesCreated() > 0;
            });

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Trainer> listTrainersBySpecialty (String keyword) {
        String query =
                """
                CALL db.index.fulltext.queryNodes("specfti", $keyword) YIELD node
                RETURN node
                """;
        Map<String, Object> params = Map.of(
                "keyword", keyword
        );

        try (Session session = AppUtils.getSession()) {
            return session.executeRead(tx -> {
                Result result = tx.run(query, params);

                return result
                        .stream()
                        .map(r -> {
                            Node node = r.get("node").asNode();

                            Trainer a = new Trainer(
                                    node.get("id").asString(),
                                    node.get("name").asString(),
                                    node.get("phone").asString(),
                                    node.get("specialty").asString()
                            );
                            System.out.println(a);
                            return a;
                        })
                        .toList();
            });

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public boolean updateSessionDuration(String memberID, String trainerID, double duration) {
        String query =
                """
                MATCH (t:Trainer)<-[r:TRAINED_BY]-(m:Member)
                WHERE r.endDate IS NOT NULL AND t.id = $trainer AND m.id = $member
                SET r.duration = $duration
                """;
        Map<String, Object> params = Map.of(
                "member", memberID,
                "trainer", trainerID,
                "duration",  duration
        );

        try (Session session = AppUtils.getSession()) {
            return session.executeWrite(tx -> {
                ResultSummary resultSummary = tx.run(query, params).consume();

                return resultSummary.counters().propertiesSet() > 0;
            });
        } catch (Exception e) {
            e.printStackTrace();
            return false;
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
