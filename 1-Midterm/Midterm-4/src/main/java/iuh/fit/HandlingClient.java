package iuh.fit;

import iuh.fit.dao.DoctorDAO;

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
                        String doctorID = in.readUTF();
                        out.writeObject(doctorDAO.findDoctoyById(doctorID));
                        out.flush();
                    }
                    case "THONG_KE_SPECIALITY" -> {
                        String departmentName = in.readUTF();
                        out.writeObject(doctorDAO.getNoOfDoctorsBySpeciality(departmentName));
                        out.flush();
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
