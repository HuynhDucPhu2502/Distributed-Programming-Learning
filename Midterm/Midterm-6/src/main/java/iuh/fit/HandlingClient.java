package iuh.fit;

import iuh.fit.dao.DoctorDAO;
import iuh.fit.model.Doctor;

import java.io.DataInputStream;

import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Admin 3/28/2025
 **/
public class HandlingClient implements Runnable {
    private Socket socket;
    private DoctorDAO doctorDAO;

    public HandlingClient(Socket socket) {
        this.socket = socket;
        this.doctorDAO = new DoctorDAO();
    }

    @Override
    public void run() {
        try  (
                DataInputStream in = new DataInputStream(socket.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())
        ) {

            while (true) {
                String command = in.readUTF();

                switch (command) {
                    case "FIND_DOCTOR" -> {
                        out.writeObject(doctorDAO.findDoctoyById(in.readUTF()));
                        out.flush();
                    }
                    case "THONG_KE_SPECIALITY" -> {
                        out.writeObject(doctorDAO.getNoOfDoctorsBySpeciality(in.readUTF()));
                        out.flush();
                    }
                    case "THEM_DOCTOR" -> {
                        out.writeBoolean(doctorDAO.addDoctor(
                                Doctor
                                        .builder()
                                        .doctorID(in.readUTF())
                                        .name(in.readUTF())
                                        .phone(in.readUTF())
                                        .speciality(in.readUTF())
                                        .build()
                        ));
                        out.flush();
                    }
                    case "SEARCH_KEYWORD" -> {
                        out.writeObject(doctorDAO.listDoctorsBySpeciality(in.readUTF()));
                        out.flush();
                    }
                    case "UPDATE_DIAG" -> {
                        out.writeBoolean(doctorDAO.updateDiagnosis(
                                in.readUTF(),
                                in.readUTF(),
                                in.readUTF()
                        ));
                        out.flush();
                    }
                    default -> out.writeUTF("Không tìm thấy không việc");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
