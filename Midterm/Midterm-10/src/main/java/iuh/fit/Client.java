package iuh.fit;

import iuh.fit.model.Level;
import iuh.fit.model.Quest;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Admin 3/31/2025
 **/
public class Client {
    public static void main(String[] args) {
        try (
                Socket socket = new Socket("Admin-PC", 9090);
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                Scanner sc = new Scanner(System.in)
        ) {
            System.out.println("Client is on");

            while (true) {
                System.out.println("1. Lấy số lượng câu hỏi theo độ khó sắp xếp tăng dần của một thể loại ");
                System.out.println("2. Lấy danh sách câu hỏi với sắp xếp giảm dần điểm  của một thể loại ");
                System.out.println("3. Thoát");
                System.out.print("Vui lòng chọn công việc: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> {
                        out.writeUTF("1");
                        System.out.print("Category Name: ");
                        out.writeUTF(sc.nextLine());
                        Map<Level, Long> res = (Map<Level, Long>) in.readObject();
                        res.forEach((k, v) -> System.out.println(k + ": " + v));
                    }
                    case 2 -> {
                        out.writeUTF("2");
                        System.out.print("Category Name: ");
                        out.writeUTF(sc.nextLine());
                        LinkedHashSet<Quest> res = (LinkedHashSet<Quest>) in.readObject();
                        res.forEach(System.out::println);

                    }
                    case 3 -> {
                        socket.close();
                        System.out.println("Client ngắt kết nối");
                        return;
                    }
                    default -> System.out.println("Lựa chọn không tồn tại vui lòng chọn lại");
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
