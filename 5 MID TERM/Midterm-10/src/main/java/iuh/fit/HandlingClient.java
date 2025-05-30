package iuh.fit;

import iuh.fit.dao.QuestDAO;

import java.io.DataInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Admin 3/31/2025
 **/
public class HandlingClient implements Runnable {
    private Socket socket;
    private QuestDAO questDAO;

    public HandlingClient(Socket socket) {
        this.socket = socket;
        this.questDAO = new QuestDAO();
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
                        out.writeObject(questDAO.countQuestLevel(in.readUTF()));
                        out.flush();
                    }
                    case "2" -> {
                        out.writeObject(questDAO.getQuestSortByPoint(in.readUTF()));
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
