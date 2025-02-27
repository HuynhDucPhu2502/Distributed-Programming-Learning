package iuh.fit.daos;

import iuh.fit.models.Course;
import iuh.fit.utils.Neo4jConnectionManager;
import iuh.fit.utils.Neo4jMapper;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.summary.ResultSummary;
import org.neo4j.driver.types.Node;

import java.util.*;

/**
 * Admin 2/27/2025
 **/
public class CourseDAO {
    public static List<Course> listCourses(int limit, int skip) {
        String query =
                """
                MATCH (n:Course)
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
                                Course.class)
                        )
                        .toList()
            );
        }
    }

    public static boolean addCourse(Course course) {
        String query =
                """
                CREATE (n:Course $course  )
                """;
        Map<String, Object> params = Map.of(
                "course", Neo4jMapper.mapClassToJson(course)
        );

        try (Session session = Neo4jConnectionManager.getSession()) {
            return session.executeWrite(transaction -> {
                Result result = transaction.run(query, params);
                ResultSummary resultSummary = result.consume();
                return resultSummary.counters().nodesCreated() > 0;
            });
        }
    }

    public static boolean deleteCourse(String courseId) {
        String query =
                """
                MATCH (n:Course { course_id: $courseId })
                DETACH DELETE n
                """;
        Map<String, Object> params = Map.of(
                "courseId", courseId
        );

        try (Session session = Neo4jConnectionManager.getSession()) {
            return session.executeWrite(transaction -> {
                Result result = transaction.run(query, params);
                ResultSummary resultSummary = result.consume();
                return resultSummary.counters().nodesDeleted() > 0;
            });
        }
    }

    public static boolean updateCourse(Course course) {
        String query =
                """
                MERGE (n:Course { course_id: $courseId })
                SET n += $course
                """;
        Map<String, Object> params = Map.of(
                "courseId", course.getCourseId(),
                "course", Neo4jMapper.mapClassToJson(course)

        );

        try (Session session = Neo4jConnectionManager.getSession()) {
            return session.executeWrite(transaction -> {
                Result result = transaction.run(query, params);
                ResultSummary resultSummary = result.consume();
                return resultSummary.counters().propertiesSet() > 0;
            });
        }
    }
}
