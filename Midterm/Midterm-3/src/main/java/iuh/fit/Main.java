package iuh.fit;

import iuh.fit.dao.DoctorDAO;

/**
 * Admin 3/28/2025
 * ${DESCRIPTION}
 **/
public class Main {
    public static void main(String[] args) {
        DoctorDAO doctorDAO = new DoctorDAO();

//        System.out.println(doctorDAO.findDoctoyById("DR.099"));
        doctorDAO.getNoOfDoctorsBySpeciality("Internal Medicine")
                .forEach((k, v) -> System.out.println(k + ": " + v));
    }
}