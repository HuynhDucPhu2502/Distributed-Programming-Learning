package iuh.fit.dao;

import iuh.fit.model.Doctor;
import iuh.fit.util.AppUtils;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.types.Node;

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

}
