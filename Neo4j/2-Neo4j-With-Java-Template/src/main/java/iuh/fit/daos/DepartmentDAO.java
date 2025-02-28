package iuh.fit.daos;

import iuh.fit.models.Department;
import iuh.fit.utils.Neo4jConnectionManager;
import iuh.fit.utils.Neo4jMapper;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.summary.ResultSummary;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public static Department findDepartmenById(String departmentId) {
        String query =
                """
                MATCH (d:Department { dept_id: $departmentId })
                RETURN d
                """;
        Map<String, Object> params = Map.of(
                "departmentId", departmentId
        );

        try (Session session = Neo4jConnectionManager.getSession()) {
            return session.executeWrite(transaction ->
                    transaction.run(query, params)
                            .stream()
                            .map(record -> Neo4jMapper
                                    .mapNodeToClass(record.get("d").asNode(), Department.class)
                            )
                            .findFirst()
                            .orElse(null)
            );
        }
    }

    public static boolean updateDepartmentName(String departmentId, String departmentName) {
        String query =
                """
                MATCH (d:Department { dept_id: $departmentId })
                SET d.name = $departmentName
                """;
        Map<String, Object> params = Map.of(
                "departmentId", departmentId,
                "departmentName", departmentName
        );

        try (Session session = Neo4jConnectionManager.getSession()) {
            return session.executeWrite(transaction ->
                    transaction.run(query, params)
                            .consume().counters().propertiesSet() > 0
            );
        }
    }

    public static List<String> getAllDepartmentDean() {
        String query =
                """
                MATCH (d:Department)
                RETURN d.dean AS dean 
                """;

        try (Session session = Neo4jConnectionManager.getSession()) {
            return session.executeRead(transaction ->
                    transaction.run(query)
                            .stream()
                            .map(record -> record.get("dean").asString())
                            .toList()
            );
        }
    }

    public static String getDeanByDepartmentId(String departmentId) {
        String query =
                """
                MATCH (d:Department {dept_id: $departmentId})
                RETURN d.dean AS dean 
                """;
        Map<String, Object> params = Map.of(
                "departmentId", departmentId
        );

        try (Session session = Neo4jConnectionManager.getSession()) {
            return session.executeRead(transaction ->
                    transaction.run(query, params)
                            .stream()
                            .map(record -> record.get("dean").asString())
                            .findFirst()
                            .orElse(null)
            );
        }
    }

    public static Map<String, Integer> getNumberOfStudentByDepartment() {
        String query =
                """
                MATCH (s:Student)-[:ENROLLED_IN]->(c:Course)-[:BELONGS_TO]->(d:Department)
                RETURN d.name as departmentName, COUNT(DISTINCT s) as studentCount
                """;

        try (Session session = Neo4jConnectionManager.getSession()) {
            return session.executeRead(transaction ->
                    transaction.run(query)
                            .stream()
                            .collect(Collectors.toMap(
                                    record -> record.get("departmentName").asString(),
                                    record -> record.get("studentCount").asInt()
                                    )
                            )
            );
        }
    }

    public static Map<String, Integer> getNumberOfStudentByDepartmentSortByDepartmentId() {
        String query =
                """
                MATCH (s:Student)-[:ENROLLED_IN]->(c:Course)-[:BELONGS_TO]->(d:Department)
                RETURN d.name as departmentName, COUNT(DISTINCT s) as studentCount, d.dept_id
                ORDER BY d.dept_id
                """;

        try (Session session = Neo4jConnectionManager.getSession()) {
            return session.executeRead(transaction ->
                    transaction.run(query)
                            .stream()
                            .collect(Collectors.toMap(
                                            record -> record.get("departmentName").asString(),
                                            record -> record.get("studentCount").asInt()
                                    )
                            )
            );
        }
    }

    public static Map<String, Integer> getNumberOfStudentByDepartmentSortByStudentCount() {
        String query =
                """
                MATCH (d:Department)  
                OPTIONAL MATCH (s:Student)-[:ENROLLED_IN]->(c:Course)-[:BELONGS_TO]->(d)
                RETURN d.name AS departmentName, COUNT(DISTINCT s) AS studentCount
                ORDER BY studentCount
            
                """;

        try (Session session = Neo4jConnectionManager.getSession()) {
            return session.executeRead(transaction ->
                    transaction.run(query)
                            .stream()
                            .collect(Collectors
                                    .toMap(
                                    record -> record.get("departmentName").asString(),
                                    record -> record.get("studentCount").asInt(),
                                    (v1, v2) -> v1,
                                    LinkedHashMap::new)
                            )
            );
        }
    }

    public static List<String> getDepartmentDeanWithMostStudent() {
        String query =
                """
                MATCH (d:Department)  
                OPTIONAL MATCH (s:Student)-[:ENROLLED_IN]->(c:Course)-[:BELONGS_TO]->(d)
                WITH COUNT(DISTINCT s) as studentCount, d.name as departmentName
                ORDER BY studentCount DESC
                LIMIT 1
                WITH studentCount AS maxStudentCount
                
                MATCH (s:Student)-[:ENROLLED_IN]->(c:Course)-[:BELONGS_TO]->(d)
                WITH d.dean as dean, COUNT(DISTINCT s) as studentCount, maxStudentCount
                WHERE studentCount = maxStudentCount
                RETURN dean
                """;

        try (Session session = Neo4jConnectionManager.getSession()) {
            return session.executeRead(transaction ->
                    transaction.run(query)
                            .stream()
                            .map(record -> record.get("dean").asString())
                            .toList()
            );
        }
    }

}
