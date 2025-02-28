package iuh.fit.daos;

import iuh.fit.models.Enrollment;
import iuh.fit.models.Student;
import iuh.fit.utils.Neo4jConnectionManager;
import iuh.fit.utils.Neo4jMapper;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.summary.ResultSummary;

import java.util.List;
import java.util.Map;

/**
 * Admin 2/28/2025
 **/
public class StudentDAO {
    public static List<Student> listStudent(int limit, int skip) {
        String query =
                """
                MATCH (n:Student)
                RETURN n
                SKIP $skip
                LIMIT $limit    
                """;
        Map<String, Object> params = Map.of(
                "skip", skip,
                "limit", limit
        );

        try (Session session = Neo4jConnectionManager.getSession()) {
            return session.executeRead(transaction ->
                    transaction
                            .run(query, params).stream()
                            .map(r -> Neo4jMapper.mapNodeToClass(
                                    r.get("n").asNode(),
                                    Student.class)
                            )
                            .toList()
            );
        }
    }

    public static boolean addStudent(Student student) {
        String query =
                """
                CREATE (n:Student $student  )
                """;
        Map<String, Object> params = Map.of(
                "student", Neo4jMapper.mapClassToJson(student)
        );

        try (Session session = Neo4jConnectionManager.getSession()) {
            return session.executeWrite(transaction -> {
                Result result = transaction.run(query, params);
                ResultSummary resultSummary = result.consume();
                return resultSummary.counters().nodesCreated() > 0;
            });
        }
    }

    public static boolean deleteStudent(String studentId) {
        String query =
                """
                MATCH (n:Student { student_id: $student_id })
                DETACH DELETE n
                """;
        Map<String, Object> params = Map.of(
                "studentId", studentId
        );

        try (Session session = Neo4jConnectionManager.getSession()) {
            return session.executeWrite(transaction -> {
                Result result = transaction.run(query, params);
                ResultSummary resultSummary = result.consume();
                return resultSummary.counters().nodesDeleted() > 0;
            });
        }
    }

    public static boolean updateStudent(Student student, String studentId) {
            String query =
                    """
                    MERGE (n:Student { student_id: $studentId })
                    SET n += $student
                    """;
            Map<String, Object> params = Map.of(
                    "studentId", studentId,
                    "student", Neo4jMapper.mapClassToJson(student, "student_id")

            );

            try (Session session = Neo4jConnectionManager.getSession()) {
                return session.executeWrite(transaction -> {
                    Result result = transaction.run(query, params);
                    ResultSummary resultSummary = result.consume();
                    return resultSummary.counters().propertiesSet() > 0;
                });
            }
        }

    public static Student findStudentById(String studentId) {
        String query =
                """
                MATCH (s:Student{student_id: $studentId})
                RETURN s
                """;
        Map<String, Object> params = Map.of(
                "studentId", studentId
        );

        try (Session session = Neo4jConnectionManager.getSession()) {
            return session.executeRead(transaction ->
                    transaction
                            .run(query, params)
                            .stream()
                            .map(record -> Neo4jMapper
                                    .mapNodeToClass(record.get("s").asNode(), Student.class)
                            )
                            .findFirst()
                            .orElse(null)
            );
        }
    }

    public static List<Enrollment> listEnrollment(String studentId) {
        String query =
                """
                MATCH (n:Student {student_id: $studentId} )-[r:ENROLLED_IN]->(c:Course)
                RETURN n, r, c
                """;
        Map<String, Object> params = Map.of(
                "studentId", studentId
        );

        try (Session session = Neo4jConnectionManager.getSession()) {
            return session.executeRead(transaction ->
                    transaction
                            .run(query, params)
                            .stream()
                            .map(record -> Enrollment
                                    .builder()
                                    .studentId(record.get("n").asNode().get("student_id").asString())
                                    .courseId(record.get("c").asNode().get("course_id").asString())
                                    .gpa(
                                            record.containsKey("gpa") && !record.get("r").isNull()
                                                    ? record.get("gpa").asDouble()
                                                    : 0.0
                                    )
                                    .build()
                            )
                            .toList()
            );
        }
    }

    public static boolean enrollCourse(String studentId, String courseId, double gpa) {
        String query =
                """
                MATCH (n:Student {student_id: $studentId} ), (c:Course {course_id: $courseId})
                MERGE (n)-[r:ENROLLED_IN]->(c)
                """;
        Map<String, Object> params = Map.of(
                "studentId", studentId,
                "courseId", courseId,
                "gpa", gpa

        );

        try (Session session = Neo4jConnectionManager.getSession()) {
            return session.executeWrite(transaction -> {
                Result result = transaction.run(query, params);
                ResultSummary resultSummary = result.consume();
                return resultSummary.counters().nodesCreated() > 0;
            });
        }
    }

    public static boolean unEnrollCourse(String studentId, String courseId) {
        String query =
                """
                MATCH (n:Student {student_id: $studentId} )-[r:ENROLLED_IN]->(c:Course {course_id: $courseId})
                DELETE r
                """;
        Map<String, Object> params = Map.of(
                "studentId", studentId,
                "courseId", courseId

        );

        try (Session session = Neo4jConnectionManager.getSession()) {
            return session.executeWrite(transaction -> {
                Result result = transaction.run(query, params);
                ResultSummary resultSummary = result.consume();
                return resultSummary.counters().relationshipsDeleted() > 0;
            });
        }
    }

    public static List<String> getStudentNameEnrolledCourse(String courseId) {
        String query =
                """
                MATCH (n:Student)-[r:ENROLLED_IN]->(c:Course {course_id: $courseId})
                RETURN n.name AS studentName
                """;
        Map<String, Object> params = Map.of(
                "courseId", courseId
        );

        try (Session session = Neo4jConnectionManager.getSession()) {
            return session.executeRead(transaction ->
                    transaction.run(query, params)
                            .stream()
                            .map(record -> record.get("studentName").asString())
                            .toList()
            );
        }
    }

    public static List<Student> getStudentAboveCertainGPASortAsc(double certainGpa) {
        String query =
                """
                MATCH (n:Student)
                WHERE n.gpa >= $gpa
                RETURN n
                ORDER BY n.gpa ASC
                """;
        Map<String, Object> params = Map.of(
                "gpa", certainGpa
        );

        try (Session session = Neo4jConnectionManager.getSession()) {
            return session.executeRead(transaction ->
                    transaction.run(query, params)
                            .stream()
                            .map(record -> Neo4jMapper.mapNodeToClass(record.get("n").asNode(), Student.class))
                            .toList()
            );
        }
    }


}
