package iuh.fit.daos;

import iuh.fit.AppUtils;
import iuh.fit.models.Course;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.summary.ResultSummary;
import org.neo4j.driver.summary.SummaryCounters;
import org.neo4j.driver.types.Node;

import java.util.Map;

public class StudentDao {
    private Driver driver;
    private SessionConfig sessionConfig;

    public StudentDao(Driver driver, String dbName) {
        this.driver = driver;
        this.sessionConfig = sessionConfig
                .builder().withDatabase(dbName).build();
    }

    public boolean enrollCourse(String studentId, String courseId){
        String query =
                "MATCH(n:Student{student_id: $studentId}), (m:Course{course_id: $courseId}) " +
                "CREATE (n)-[:ENROLLED]->(m) ";
        Map<String, Object> parameter = Map.of(
                "studentId", studentId,
                "courseId", courseId
        );
        try (Session session = driver.session(sessionConfig)){
            return session.executeWrite(tx -> {
                ResultSummary summary = tx.run(query, parameter).consume();
                SummaryCounters counters = summary.counters();
                return counters.nodesCreated() > 0;
            });

        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean unenrollCourse(String studentId, String courseId){
        String query =
                "MATCH (n:Student{student_id: $studentId})-[r:ENROLLED]->(m:Course{course_id: $courseId})" +
                        "DELETE r";
        Map<String, Object> parameter = Map.of(
                "studentId", studentId,
                "courseId", courseId
        );
        try (Session session = driver.session(sessionConfig)){
            return session.executeWrite(tx -> {
                ResultSummary summary = tx.run(query, parameter).consume();
                SummaryCounters counters = summary.counters();
                return counters.nodesDeleted() > 0;
            });

        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateEnrollment(String studentId, String courseId, double grade){
        String query =
                "MATCH (n:Student{student_id: $studentId})-[r:ENROLLED]->(m:Course{course_id: $courseId}) " +
                        "SET r.grade = $grade";
        Map<String, Object> parameter = Map.of(
                "studentId", studentId,
                "courseId", courseId,
                "grade", grade
        );
        try (Session session = driver.session(sessionConfig)){
            return session.executeWrite(tx -> {
                ResultSummary summary = tx.run(query, parameter).consume();
                SummaryCounters counters = summary.counters();
                return counters.propertiesSet() > 0;
            });

        }catch(Exception e){
            e.printStackTrace();
        }
        return false;

    }


}
