package iuh.fit;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Admin 3/30/2025
 **/
public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(9090)) {
            System.out.println("Server is on");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Kết nối: " + socket.getInetAddress().getHostName());

                new Thread(new HandlingClient(socket)).start();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
