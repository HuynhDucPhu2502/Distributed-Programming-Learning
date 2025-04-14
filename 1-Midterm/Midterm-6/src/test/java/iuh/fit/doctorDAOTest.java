package iuh.fit;

import iuh.fit.dao.DoctorDAO;
import iuh.fit.model.Doctor;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Admin 3/29/2025
 **/

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class doctorDAOTest {
    private DoctorDAO doctorDAO;

    @BeforeAll
    void startup() {
        doctorDAO = new DoctorDAO();
    }

    @AfterAll
    void teardown() {
        doctorDAO = null;
    }

    // findDoctoyById
    @Test
    void findDoctorByIdTest() {
        Doctor doctor = doctorDAO.findDoctoyById("DR.001");

        assertEquals("Dermatology Services", doctor.getSpeciality());
        assertEquals("John Smith", doctor.getName());
        assertEquals("0987.654.321", doctor.getPhone());
    }

    @Test
    void findDoctorByIdNullTest() {
        Doctor doctor = doctorDAO.findDoctoyById("Huynh Duc Phu");

        assertNull(doctor);
    }

    // getNoOfDoctorsBySpeciality
    @Test
    void getNoOfDoctorsBySpecialityTest() {
        Map<String, Long> res = doctorDAO.getNoOfDoctorsBySpeciality("Internal Medicine");

        assertEquals(5, res.size());
        assertEquals(1, res.get("Dermatology Services"));
        assertEquals(2, res.get("Internal Medicine"));
    }

    @Test
    void getNoOfDoctorsBySpecialityEmptyMapTest() {
        Map<String, Long> res = doctorDAO.getNoOfDoctorsBySpeciality("Huynh Duc Phu");

        assertEquals(0, res.size());
    }


    // addDoctor
    @Test
    void addDoctorTest() {
        Doctor newDoctor = Doctor
                .builder()
                .name("IUH")
                .speciality("Test")
                .doctorID("DR.789")
                .phone("123456")
                .build();

        assertTrue(doctorDAO.addDoctor(newDoctor));

        Doctor doctor = doctorDAO.findDoctoyById("DR.789");

        assertEquals("Test", doctor.getSpeciality());
        assertEquals("IUH", doctor.getName());
        assertEquals("123456", doctor.getPhone());
    }

    @Test
    void addDoctorFailTest() {
        Doctor newDoctor = Doctor
                .builder()
                .name("IUH")
                .speciality("Test")
                .doctorID("DR.001")
                .phone("123456")
                .build();

        assertFalse(doctorDAO.addDoctor(newDoctor));
    }

    // listDoctorsBySpeciality
    @Test
    void listDoctorsBySpecialityTest() {
        List<Doctor> doctors = doctorDAO.listDoctorsBySpeciality("Dermatology Internal Medicine");

        assertEquals(12, doctors.size());
        assertEquals("Robert Jones", doctors.getFirst().getName());
        assertEquals("Joseph Robinson", doctors.getLast().getName());
    }

    @Test
    void listDoctorsBySpecialityEmptyListTest() {
        List<Doctor> doctors = doctorDAO.listDoctorsBySpeciality("Huynh Duc Phu");

        assertEquals(0, doctors.size());
    }

    // updateDiagnosis
    @Test
    void updateDiagnosisTest() {
        assertTrue(doctorDAO.updateDiagnosis("PT007", "DR.007", "Test"));
    }

    @Test
    void updateDiagnosisFailTest() {
        assertFalse(doctorDAO.updateDiagnosis("PT001", "DR.003", "Test"));
    }





}
