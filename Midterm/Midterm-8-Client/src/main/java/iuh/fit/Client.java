package iuh.fit;

import iuh.fit.model.Doctor;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Admin 3/30/2025
 **/
public class Client {
    public static void main(String[] args) {
        try (
                Socket socket = new Socket("192.168.100.4", 9090);
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                Scanner sc = new Scanner(System.in);
        ) {
            System.out.println("Client is on");

            while (true) {
                System.out.println("1. Thêm mới một bác sỹ");
                System.out.println("2. Thống kê số bác sỹ theo từng chuyên khoa (speciality) của một khoa");
                System.out.println("3. Tìm kiếm các bác sỹ theo chuyên khoa");
                System.out.println("4. Cập nhật lại chẩn đoán");
                System.out.println("5. Thoát");
                System.out.print("Chọn công việc của bạn: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 5 -> {
                        socket.close();
                        System.out.println("Ngắt kết nối");
                        return;
                    }
                    default -> System.out.println("Lựa chọn không tồn tại");
                    case 1 -> {
                        out.writeUTF("1");
                        System.out.print("ID: ");
                        out.writeUTF(sc.nextLine());
                        System.out.print("Name: ");
                        out.writeUTF(sc.nextLine());
                        System.out.print("Phone: ");
                        out.writeUTF(sc.nextLine());
                        System.out.print("Spec: ");
                        out.writeUTF(sc.nextLine());
                        out.flush();
                        boolean isAdded = in.readBoolean();
                        System.out.println(isAdded ? "Thành công" : "Thất bại");
                    }
                    case 2 -> {
                        out.writeUTF("2");
                        System.out.print("Nhập departmentName: ");
                        out.writeUTF(sc.nextLine());
                        out.flush();
                        Map<String, Long> res = (Map<String, Long>) in.readObject();
                        res.forEach((k, v) -> System.out.println(k + ":" + v));
                    }
                    case 3 -> {
                        out.writeUTF("3");
                        System.out.print("keyword: ");
                        out.writeUTF(sc.nextLine());
                        out.flush();
                        List<Doctor> doctors = (List<Doctor>) in.readObject();
                        doctors.forEach(System.out::println);
                    }
                    case 4 -> {
                        out.writeUTF("4");
                        System.out.print("PatientID: ");
                        out.writeUTF(sc.nextLine());
                        System.out.print("DoctorID: ");
                        out.writeUTF(sc.nextLine());
                        System.out.print("Diag: ");
                        out.writeUTF(sc.nextLine());
                        out.flush();
                        boolean isUpdated = in.readBoolean();
                        System.out.println(isUpdated ? "Thành công" : "Thất bại");

                    }
                }


            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
