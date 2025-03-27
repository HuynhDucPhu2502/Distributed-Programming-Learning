package iuh.fit.client;

import iuh.fit.model.Supplier;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Admin 3/24/2025
 **/
public class Client2 {
    public static void main(String[] args) throws Exception {
        try (
                Socket socket2 = new Socket("192.168.29.83", 2211);
                ObjectInputStream in = new ObjectInputStream(socket2.getInputStream());
                DataOutputStream out = new DataOutputStream(socket2.getOutputStream());
                Scanner scanner = new Scanner(System.in)
        ) {
            while(true) {
                // Gửi từ client
                System.out.println("Enter supplier ID: ");
                int id = scanner.nextInt();
                out.writeInt(id);

                // Nhận từ server
                Supplier supplier = (Supplier) in.readObject();
                System.out.println(supplier);


            }
        }
    }
}
