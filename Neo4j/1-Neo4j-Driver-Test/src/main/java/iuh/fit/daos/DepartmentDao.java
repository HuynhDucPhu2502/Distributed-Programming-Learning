package iuh.fit.daos;

import iuh.fit.AppUtils;
import iuh.fit.models.Department;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.summary.ResultSummary;
import org.neo4j.driver.summary.SummaryCounters;
import org.neo4j.driver.types.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DepartmentDao {

    private Driver driver;
    private SessionConfig sessionConfig;

    public DepartmentDao(Driver driver, String dbName) {
        this.driver = driver;
        this.sessionConfig = SessionConfig
                .builder()
                .withDatabase(dbName)
                .build();
    }

    public Map<Department, Long> listEnrollmentNumberByDepartment() {
        String query = "MATCH p=(s:Student)-[r1:ENROLLED]->(c:Course)-[r2:BELONGS_TO]->(d:Department)\n" +
                "RETURN d, COUNT(*) as `enrollment number`\n";
        try (Session session = driver.session(sessionConfig)) {
            return session.executeRead(tx -> {
                Result rs = tx.run(query);
                return rs.stream().collect(Collectors.toMap(
                        record -> {
                            Node node = record.get("d").asNode();
                            return AppUtils.toObject(node, Department.class);
                        },

                        record -> record.get("enrollment number").asLong()
                ));
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Department> searchDepartment(String searchStr) {
        String query =
                "CALL db.index.fulltext.queryNodes('deparmentTextIndex', $searchStr) YIELD node, score " +
                        "RETURN node";
        Map<String, Object> parameter = Map.of(
                "searchStr", searchStr
        );

        ArrayList<Department> res = new ArrayList<>();

        try (Session session = driver.session(sessionConfig)) {
            return session.readTransaction(tx -> {
                Result result = tx.run(query, parameter);
                while (result.hasNext()) {
                    Record record = result.next();
                    Node node = record.get("node").asNode();
                    res.add(AppUtils.toObject(node, Department.class));
                }
                return res;
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateDateDepartment(){
        String query =
                "MATCH (n:Department) " +
                        "SET n.date_created = date()";
        try (Session session = driver.session(sessionConfig)){
            return session.executeWrite(tx -> {
                ResultSummary summary = tx.run(query).consume();
                SummaryCounters counters = summary.counters();
                return counters.propertiesSet() > 0;
            });

        }catch(Exception e){
            e.printStackTrace();
        }
        return false;

    }

}
