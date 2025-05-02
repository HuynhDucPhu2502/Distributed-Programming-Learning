package iuh.fit.daos;

import iuh.fit.models.Student;
import iuh.fit.utils.Neo4jConnectionManager;
import iuh.fit.utils.Neo4jMapper;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;

import java.util.List;
import java.util.Map;

/**
 * Admin 3/2/2025
 **/
public class StudentDAO {

    public static boolean addStudent(Student student) {
        String query =
                """
                CREATE (s: Student $student )
                """;

        Map<String, Object> studentMap = Neo4jMapper.mapClassToMap(student, "dob");
        studentMap.put("date_of_birth", student.getDob());


        Map<String, Object> params = Map.of("student", studentMap);

        try (Session session = Neo4jConnectionManager.getDriver().session()) {
            return session.executeWrite(transactionContext ->
                    transactionContext.run(query, params).consume().counters().nodesCreated() > 0
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Student> listStudent() {
        String query =
                """
                MATCH (s: Student )
                RETURN s
                """;

        try (Session session = Neo4jConnectionManager.getDriver().session()) {
            return session.executeRead(transactionContext ->
                    transactionContext
                            .run(query)
                            .stream()
                            .map(record ->
                                    Neo4jMapper.mapNodeToClass(
                                            record.get("s").asNode(),
                                            Student.class
                                    )
                            )
                            .toList()
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean updateStudent(String studentId, Student student) {
        String query =
                """
                MERGE (s: Student {student_id: $student_id})
                SET s += $student
                """;

        Map<String, Object> studentMap = Neo4jMapper.mapClassToMap(student, "dob");
        studentMap.put("date_of_birth", student.getDob());


        Map<String, Object> params = Map.of(
                "student_id", studentId
                ,"student", studentMap
        );

        try (Session session = Neo4jConnectionManager.getDriver().session()) {
            return session.executeWrite(transactionContext ->
                    transactionContext.run(query, params).consume().counters().propertiesSet() > 0
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
