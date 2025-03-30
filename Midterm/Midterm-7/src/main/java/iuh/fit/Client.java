package iuh.fit;

import iuh.fit.model.Movie;
import iuh.fit.model.Person;

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
            System.out.println("Client đã khởi động");

            while (true) {
                System.out.println("1. Liệt kê danh sách những phim mà tiêu đề có chứa từ");
                System.out.println("2. Thêm phim");
                System.out.println("3. Liệt kê danh sách các bộ phim theo diễn viên tên đóng và năm phát hành ");
                System.out.println("4. Thống kê số lượng phim mà diễn viên đã đóng trong khoảng năm");
                System.out.println("5. Tìm kiếm các diễn viên chứa tên keyword");
                System.out.println("6. Thoát");
                System.out.print("Vui lòng chọn công việc: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> {

                    }
                    case 2 -> {

                    }
                    case 3 -> {

                    }
                    case 4 -> {

                    }
                    case 5 -> {

                    }

                    case 6 -> {
                        System.out.println("Ngắt kết nối");
                        socket.close();
                        return;
                    }
                    default -> System.out.println("Lựa chọn không tồn tại, vui lòng chọn lại");
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
