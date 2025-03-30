package iuh.fit.dao;

import iuh.fit.model.Doctor;
import iuh.fit.util.AppUtils;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.summary.ResultSummary;
import org.neo4j.driver.types.Node;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Admin 3/30/2025
 **/
public class DoctorDAO {

    public boolean addDoctor(Doctor doctor) {
        String query =
                """
                CREATE (d:Doctor)
                SET d.id = $id, d.name = $name, d.phone = $phone, d.speciality = $spec
                RETURN d
                """;
        Map<String, Object> params = Map.of(
                "id", doctor.getId(),
                "name", doctor.getName(),
                "phone", doctor.getPhone(),
                "spec", doctor.getSpeciality()
        );

        try (Session session = AppUtils.getSession()) {
            return session.executeWrite(tx -> {
                ResultSummary resultSummary = tx.run(query, params).consume();

                return resultSummary.counters().nodesCreated() > 0;
            });
        } catch (Exception e) {
            return false;
        }

    }

    public Map<String,Long> getNoOfDoctorsBySpeciality(String departmentName) {
        String query =
                """
                MATCH (d:Doctor)-[r:BELONG_TO]->(dep:Department)
                WHERE dep.name = $depName
                RETURN d.speciality as speciality, count(d) as total
                """;
        Map<String, Object> params = Map.of(
                "depName", departmentName
        );

        try (Session session = AppUtils.getSession()) {
            return session.executeRead(tx -> {
                Result res = tx.run(query, params);

                return res
                        .stream()
                        .collect(Collectors.toMap(
                                r -> r.get("speciality").asString(),
                                r -> r.get("total").asLong()
                        ));
            });
        }

    }

    public List<Doctor> listDoctorsBySpeciality(String keyword) {
        String query =
                """
                CALL db.index.fulltext.queryNodes("specFTI", $keyword) YIELD node
                RETURN node
                """;
        Map<String, Object> params = Map.of(
                "keyword", keyword
        );

        try (Session session = AppUtils.getSession()) {
            return session.executeRead(tx -> {
                Result res = tx.run(query, params);

                return res
                        .stream()
                        .map(r -> {
                            Node node = r.get("node").asNode();

                            return new Doctor(
                                    node.get("id").asString(),
                                    node.get("name").asString(),
                                    node.get("phone").asString(),
                                    node.get("speciality").asString()
                            );
                        })
                        .toList();
            });
        }
    }

    public boolean updateDiagnosis(String patientID, String doctorID, String diagnosis) {
        String query =
                """
                MATCH (d:Doctor)<-[r:BE_TREATED]-(p:Patient)
                WHERE r.endDate IS NULL AND d.id = $docID AND p.id= $patID
                SET r.diagnosis = $diag
                """;
        Map<String, Object> params = Map.of(
                "docID", doctorID,
                "patID", patientID,
                "diag", diagnosis
        );

        try (Session session = AppUtils.getSession()) {
            return session.executeWrite(tx ->{
                ResultSummary resultSummary = tx.run(query, params).consume();

                return resultSummary.counters().propertiesSet() > 0;
            });
        }

    }

}
