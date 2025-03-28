package iuh.fit;

import iuh.fit.model.Doctor;

import javax.print.Doc;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;

/**
 * Admin 3/28/2025
 **/
public class Client {
    public static void main(String[] args) {
        try (
                Socket socket = new Socket("192.168.100.4", 9090);
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                Scanner sc = new Scanner(System.in)
        ) {
            System.out.println("Client đã khởi động");

            while (true) {
                System.out.println("1. Tìm Doctor theo ID");
                System.out.println("2. Thống kê số lượng speciality theo tên phòng ban");
                System.out.println("3. Thoát");
                System.out.print("Vui lòng chọn công việc: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> {
                        out.writeUTF("FIND_DOCTOR");
                        System.out.print("Nhập DoctorID cần tìm: ");
                        String doctorID = sc.next();
                        sc.nextLine();
                        out.writeUTF(doctorID);
                        out.flush();
                        Doctor doctor = (Doctor) in.readObject();
                        System.out.println(doctor);
                    }
                    case 2 -> {
                        out.writeUTF("THONG_KE_SPECIALITY");
                        System.out.print("Nhập tên phòng ban cần thống kê: ");
                        String departmentName = sc.nextLine();
                        out.writeUTF(departmentName);
                        out.flush();
                        Map<String, Long> res = (Map<String, Long>) in.readObject();
                        res.forEach((k, v) -> System.out.println(k + ": " + v));
                    }
                    case 3 -> {
                        socket.close();
                        System.out.println("Client đã ngắt kết nối");
                        return;
                    }
                    default -> {
                        System.out.println("Lựa chọn không tồn tại, vui lòng chọn lại");
                    }
                }


            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
