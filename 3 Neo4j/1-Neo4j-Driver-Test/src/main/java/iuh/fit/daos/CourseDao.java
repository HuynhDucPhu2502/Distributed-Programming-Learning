package iuh.fit.daos;

import iuh.fit.AppUtils;
import iuh.fit.models.Course;
import iuh.fit.models.Department;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.summary.ResultSummary;
import org.neo4j.driver.summary.SummaryCounters;
import org.neo4j.driver.types.Node;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class CourseDao {

    private Driver driver;
    private SessionConfig sessionConfig;

    public CourseDao(Driver driver, String dbName) {
        this.driver = driver;
        this.sessionConfig = sessionConfig
                .builder().withDatabase(dbName).build();
    }

    public boolean addCourse(Course course){
        String query = "CREATE (n:Course{course_id:$id, name:$name, hours:$hours})";
        Map<String, Object> parameter = Map.of(
                "id", course.getId(),
                "name", course.getName(),
                "hours", course.getHours()
        );
        try (Session session = driver.session(sessionConfig)){
            return session.executeWrite(tx -> {
                ResultSummary summary = tx.run(query, parameter).consume();
                SummaryCounters counters = summary.counters();
                return counters.nodesCreated() > 0;
            });
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateCourse(Course course){
        String query = "MERGE (n:Course{course_id:$id})\n" +
                "SET\n" +
                "  n.name = $name,\n" +
                "  n.hours = $hours";
        Map<String, Object> parameter = Map.of(
                "id", course.getId(),
                "name", course.getName(),
                "hours", course.getHours()
        );
        try (Session session = driver.session(sessionConfig)){
            return session.executeWrite(tx -> {
                ResultSummary summary = tx.run(query, parameter).consume();
                SummaryCounters counters = summary.counters();
                return counters.containsUpdates();
            });
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteCourse(String courseId){
        String query = "MATCH (n:Course{course_id:$id}) DETACH DELETE n";
        Map<String, Object> parameter = Map.of(
                "id", courseId
        );
        try (Session session = driver.session(sessionConfig)){
            return session.executeWrite(tx -> {
                ResultSummary summary = tx.run(query, parameter).consume();
                SummaryCounters counters = summary.counters();
                return counters.nodesDeleted() > 0;
            });
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Course findCourseById(String courseId){
        String query = "MATCH (n:Course{course_id: $id}) RETURN n";
        Map<String, Object> parameter = Map.of(
                "id", courseId
        );
        try (Session session = driver.session(sessionConfig)){
            return session.executeRead(tx -> {
                Result rs = tx.run(query, parameter);
                if(!rs.hasNext()){
                    return null;
                }
                Record record = rs.single();
                Node node = record.get("n").asNode();
                Course course = AppUtils.toObject(node, Course.class);
                return course;
            });
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Course> listCourses(int skip, int limit){
        String query = "MATCH (n:Course) RETURN n SKIP $skip LIMIT $limit";
        Map<String, Object> map = Map.of(
                "skip", skip,
                "limit", limit
        );
        try (Session session = driver.session(sessionConfig)){
            return session.executeRead(tx -> {
                Result rs = tx.run(query, map);
                return rs.list(record -> {
                    Node node = record.get("n").asNode();
                    return AppUtils.toObject(node, Course.class);
                });
            });
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Course> listCourses(){
        return listCourses(0, 10);
    }
}
