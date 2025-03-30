package iuh.fit;

import iuh.fit.dao.DoctorDAO;
import iuh.fit.model.Doctor;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Admin 3/30/2025
 **/
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DoctorDAOTest {
    private DoctorDAO doctorDAO;

    @BeforeAll
    void setup() {
        doctorDAO = new DoctorDAO();
    }

    @AfterAll
    void teardown() {
        doctorDAO = null;
    }

    @Test
    void addDoctorTest() {
        Doctor doctor = new Doctor("DR.444", "IUH", "000", "Test");

        assertTrue(doctorDAO.addDoctor(doctor));
    }

    @Test
    void addDoctorFailTest() {
        Doctor doctor = new Doctor("DR.444", "IUH", "000", "Test");

        assertFalse(doctorDAO.addDoctor(doctor));
    }

    @Test
    void getNoOfDoctorsBySpecialityTest() {
        Map<String, Long> res = doctorDAO.getNoOfDoctorsBySpeciality("Internal Medicine");

        assertEquals(5, res.size());
        assertEquals(1, res.get("Dermatology Services"));
        assertEquals(2, res.get("Internal Medicine"));
    }

    @Test
    void getNoOfDoctorsBySpecialityFailTest() {
        Map<String, Long> res = doctorDAO.getNoOfDoctorsBySpeciality("Ifsafsafsafsaf");

        assertEquals(0, res.size());
    }

    @Test
    void listDoctorsBySpecialityTest() {
        List<Doctor> res = doctorDAO.listDoctorsBySpeciality("Internal");

        assertEquals(2, res.size());
    }

    @Test
    void updateDiagnosisTest() {
        assertFalse(doctorDAO.updateDiagnosis("DR.123", "DR.123", "Test"));
    }


}
