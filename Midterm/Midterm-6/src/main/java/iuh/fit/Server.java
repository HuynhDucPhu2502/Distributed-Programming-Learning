package iuh.fit;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Admin 3/28/2025
 **/
public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(9090)) {
            System.out.println("Server đã khởi động");

            while (true) {
                Socket socket = serverSocket.accept();

                System.out.println("Một client đã kết nối");
                System.out.println("========= Thông tin Client =========");
                System.out.println("IP: " + socket.getInetAddress().getHostAddress());
                System.out.println("Port: " + socket.getPort());
                System.out.println("==================================");

                new Thread(new HandlingClient(socket)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
