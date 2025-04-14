package iuh.fit;

import iuh.fit.dao.TrainerDAO;
import iuh.fit.model.Trainer;

import java.io.DataInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Admin 3/31/2025
 **/
public class HandlingClient implements Runnable {
    private Socket socket;
    private TrainerDAO trainerDAO;

    public HandlingClient(Socket socket) {
        this.socket = socket;
        this.trainerDAO = new TrainerDAO();
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
                        out.writeObject(trainerDAO.getNoOfTrainersBySpecialty(in.readUTF()));
                        out.flush();
                    }
                    case "2" -> {
                        out.writeBoolean(
                                trainerDAO.addTrainerToCenter(
                                        new Trainer(
                                                in.readUTF(),
                                                in.readUTF(),
                                                in.readUTF(),
                                                in.readUTF()
                                        ),
                                        in.readUTF()
                                )
                        );
                        out.flush();
                    }
                    case "3" -> {
                        out.writeObject(trainerDAO.listTrainersBySpecialty(in.readUTF()));
                        out.flush();
                    }
                    case "4" -> {
                        out.writeObject(trainerDAO.updateSessionDuration(
                                in.readUTF(),
                                in.readUTF(),
                                in.readDouble()
                        ));
                        out.flush();
                    }
                    default -> out.writeUTF("Lựa chọn không tồn tại");
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
