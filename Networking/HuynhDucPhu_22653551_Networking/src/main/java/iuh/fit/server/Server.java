package iuh.fit.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws Exception {
        try (ServerSocket serverSocket = new ServerSocket(8079)) {
            System.out.println("Server is ready!!!");

            while (true) {
                Socket socket = serverSocket.accept();

                System.out.println("Client's hostname: " + socket.getInetAddress().getHostName());
                System.out.println("Client's IP address: " + socket.getInetAddress().getHostAddress());
                System.out.println("Client's port: " + socket.getPort());


                Thread thread = new Thread(new HandlingSocket2(socket));
                thread.start();
            }
        }
    }

}

class HandlingSocket implements Runnable {
    private Socket socket;

    public HandlingSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
             DataInputStream in = new DataInputStream(socket.getInputStream());
             DataOutputStream out = new DataOutputStream(socket.getOutputStream());

             Scanner scanner = new Scanner(System.in)
        ) {
            while(true) {
                // Nhận từ client
                String message = in.readUTF();
                System.out.println("Client's message: " + message);

                // Gửi từ server
                System.out.println("Write your message: ");
                message = scanner.nextLine();
                out.writeUTF(message);


            }
        } catch (Exception e) {

        }
    }
}
