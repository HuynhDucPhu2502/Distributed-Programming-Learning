package iuh.fit.daos;

import iuh.fit.models.Department;
import iuh.fit.utils.Neo4jConnectionManager;
import iuh.fit.utils.Neo4jMapper;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.summary.ResultSummary;

import java.util.List;
import java.util.Map;

/**
 * Admin 2/27/2025
 **/
public class DepartmentDAO {
    public static List<Department> listDepartment(int limit, int skip) {
        String query =
                """
                MATCH (n:Department)
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
                                    Department.class)
                            )
                            .toList()
            );
        }
    }

    public static boolean addDepartment(Department department) {
        String query =
                """
                CREATE (n:Department $department  )
                """;
        Map<String, Object> params = Map.of(
                "department", Neo4jMapper.mapClassToJson(department)
        );

        try (Session session = Neo4jConnectionManager.getSession()) {
            return session.executeWrite(transaction -> {
                Result result = transaction.run(query, params);
                ResultSummary resultSummary = result.consume();
                return resultSummary.counters().nodesCreated() > 0;
            });
        }
    }

    public static boolean deleteDepartment(String departmentId) {
        String query =
                """
                MATCH (n:Department { dept_id: $departmentId })
                DETACH DELETE n
                """;
        Map<String, Object> params = Map.of(
                "departmentId", departmentId
        );

        try (Session session = Neo4jConnectionManager.getSession()) {
            return session.executeWrite(transaction -> {
                Result result = transaction.run(query, params);
                ResultSummary resultSummary = result.consume();
                return resultSummary.counters().nodesDeleted() > 0;
            });
        }
    }

    public static boolean updateDepartment(Department department) {
        String query =
                """
                MERGE (n:Department { course_id: $departmentId })
                SET n += $department
                """;
        Map<String, Object> params = Map.of(
                "departmentId", department.getDepartmentId(),
                "department", Neo4jMapper.mapClassToJson(department)

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
