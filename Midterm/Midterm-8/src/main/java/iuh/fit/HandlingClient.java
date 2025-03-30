package iuh.fit;

import iuh.fit.dao.DoctorDAO;
import iuh.fit.model.Doctor;

import java.io.DataInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Admin 3/30/2025
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
        try (
                DataInputStream in = new DataInputStream(socket.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())
                ) {

            while (true) {
                String command = in.readUTF();

                switch (command) {
                    case "1" -> {
                        out.writeBoolean(doctorDAO.addDoctor(
                                new Doctor(in.readUTF(), in.readUTF(), in.readUTF(), in.readUTF())
                        ));
                        out.flush();
                    }
                    case "2" -> {
                        out.writeObject(doctorDAO.getNoOfDoctorsBySpeciality(in.readUTF()));
                        out.flush();
                    }
                    case "3" -> {
                        out.writeObject(doctorDAO.listDoctorsBySpeciality(in.readUTF()));
                        out.flush();
                    }
                    case "4" -> {
                        out.writeBoolean(doctorDAO.updateDiagnosis(in.readUTF(), in.readUTF(), in.readUTF()));
                        out.flush();
                    }
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
