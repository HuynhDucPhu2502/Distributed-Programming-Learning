package iuh.fit;

import iuh.fit.model.Trainer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Admin 3/31/2025
 **/
public class Client {
    public static void main(String[] args) {
        try (
                Socket socket = new Socket("192.168.100.4", 9090);
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                Scanner sc = new Scanner(System.in)
        ) {
            System.out.println("Client is on");

            while (true) {
                System.out.println("1. Thống kê số huấn luyện viên theo từng chuyên môn của một trung tâm ");
                System.out.println("2. Thêm mới một huấn luyện viên vào trung tâm");
                System.out.println("3. Tìm kiếm các huấn luyện viên theo chuyên môn.");
                System.out.println("4. ");
                System.out.println("5. Thoát");
                System.out.print("Vui lòng chọn công việc: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> {
                        out.writeUTF("1");
                        System.out.print("Center Name: ");
                        out.writeUTF(sc.nextLine());
                        out.flush();

                        Map<String, Long> res = (Map<String, Long>) in.readObject();
                        res.forEach((k, v) -> System.out.println(k + ":" + v));
                    }
                    case 2 -> {
                        out.writeUTF("2");
                        System.out.print("ID: ");
                        out.writeUTF(sc.nextLine());
                        System.out.print("Name: ");
                        out.writeUTF(sc.nextLine());
                        System.out.print("Phone: ");
                        out.writeUTF(sc.nextLine());
                        System.out.print("Spec: ");
                        out.writeUTF(sc.nextLine());
                        System.out.print("Center Name: ");
                        out.writeUTF(sc.nextLine());
                        out.flush();

                        boolean isAdded = in.readBoolean();
                        System.out.println(isAdded ? "Thêm thành công" : "Thất bại");
                    }
                    case 3 -> {
                        out.writeUTF("3");
                        System.out.print("Keyword: ");
                        out.writeUTF(sc.nextLine());
                        out.flush();

                        List<Trainer> trainers = (List<Trainer>)in.readObject();
                        trainers.forEach(System.out::println);
                    }
                    case 4 -> {
                        out.writeUTF("4");
                        System.out.print("MemberID: ");
                        out.writeUTF(sc.nextLine());
                        System.out.print("TrainerID: ");
                        out.writeUTF(sc.nextLine());
                        System.out.print("Duration: ");
                        out.writeDouble(sc.nextDouble());
                        sc.nextLine();
                        out.flush();

                    }
                    case 5 -> {
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
