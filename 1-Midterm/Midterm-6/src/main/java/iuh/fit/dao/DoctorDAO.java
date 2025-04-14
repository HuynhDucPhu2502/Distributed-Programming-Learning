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
 * Admin 3/28/2025
 **/
public class DoctorDAO {

    public Doctor findDoctoyById(String doctorID) {
        String query =
                """
                MATCH (d:Doctor)
                WHERE d.doctor_id = $doctorID
                RETURN d
                """;
        Map<String, Object> params = Map.of(
                "doctorID", doctorID
        );

        try (Session session = AppUtils.getSession()) {
            return session.executeRead(tx -> {
                Result result = tx.run(query, params);

                if (result.hasNext()) {
                    Node node = result.next().get("d").asNode();

                    return Doctor
                            .builder()
                            .speciality(node.get("speciality").asString())
                            .doctorID(node.get("doctor_id").asString())
                            .phone(node.get("phone").asString())
                            .name(node.get("name").asString())
                            .departmentID(node.get("dept_id").asString())
                            .build();
                }

                return null;
            });
        }
    }

    public Map<String, Long> getNoOfDoctorsBySpeciality(String departmentName) {
        String query =
                """
                MATCH (d:Doctor)-[r:BELONG_TO]->(dp:Department)
                WHERE dp.name = $departmentName
                RETURN d.speciality as speciality, count(d) as total
                """;
        Map<String, Object> params = Map.of(
                "departmentName", departmentName
        );

        try (Session session = AppUtils.getSession()) {
            return session.executeRead(tx -> {
                Result result = tx.run(query, params);

                return result
                        .stream()
                        .collect(Collectors.toMap(
                                r -> r.get("speciality").asString(),
                                r -> r.get("total").asLong()
                        ));
            });
        }
    }

    public boolean addDoctor(Doctor doctor) {
        String query =
                """
                CREATE (d:Doctor)
                SET d.doctor_id = $doctorID, d.name = $name,
                d.phone = $phone, d.speciality = $speciality
                RETURN d
                """;

        Map<String, Object> params = Map.of(
                "doctorID", doctor.getDoctorID(),
                "name", doctor.getName(),
                "phone", doctor.getPhone(),
                "speciality", doctor.getSpeciality()
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

    public List<Doctor> listDoctorsBySpeciality(String keyword) {
        String query =
                """
                CALL db.index.fulltext.queryNodes("specialityFTI", $keyword) YIELD node
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

                            return Doctor
                                    .builder()
                                    .speciality(node.get("speciality").asString())
                                    .doctorID(node.get("doctor_id").asString())
                                    .phone(node.get("phone").asString())
                                    .name(node.get("name").asString())
                                    .build();

                        })
                        .toList();
            });

        }
    }

    public boolean updateDiagnosis(String patientID, String doctorID, String newDiagnosis) {
        String query =
                """
                MATCH (d:Doctor)<-[r:BE_TREATED]-(p:Patient)
                WHERE d.doctor_id = $doctorID AND p.patient_id = $patientID AND r.endDate IS NULL
                SET r.diagnosis = $newDiagnosis
                """;

        Map<String, Object> params = Map.of(
                "doctorID", doctorID,
                "patientID", patientID,
                "newDiagnosis", newDiagnosis
        );

        try (Session session = AppUtils.getSession()) {
            return session.executeWrite(tx -> {
                ResultSummary resultSummary = tx.run(query, params).consume();

                return resultSummary.counters().propertiesSet() > 0;
            });
        }

    }

}
