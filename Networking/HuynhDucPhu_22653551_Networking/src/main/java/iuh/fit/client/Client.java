package iuh.fit.client;

import iuh.fit.dao.SupplierDAO;
import iuh.fit.dao.SupplierDAOImpl;
import iuh.fit.model.Supplier;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Admin 3/24/2025
 **/
public class Client {
    public static void main(String[] args) throws Exception {
        try (
                Socket socket = new Socket("192.168.29.117", 8079);
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                Scanner scanner = new Scanner(System.in)
        ) {
            while(true) {
                // Gửi từ client
                System.out.println("Write your message: ");
                String message = scanner.nextLine();
                out.writeUTF(message);

                // Nhận từ server
                message = in.readUTF();
                System.out.println("Client's message: " + message);


            }
        }
    }
}
