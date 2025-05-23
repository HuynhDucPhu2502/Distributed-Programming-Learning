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
                        out.writeUTF("CONTAINS_NAME");
                        System.out.print("Nhập tên phim: ");
                        out.writeUTF(sc.nextLine());
                        out.flush();
                        List<Movie> res = (List<Movie>)in.readObject();
                        res.forEach(System.out::println);
                    }
                    case 2 -> {
                        out.writeUTF("CREATE_MOVIE");
                        System.out.print("Nhập title: ");
                        out.writeUTF(sc.nextLine());
                        System.out.print("Nhập tagline: ");
                        out.writeUTF(sc.nextLine());
                        System.out.print("Nhập released: ");
                        out.writeInt(sc.nextInt());
                        sc.nextLine();
                        out.flush();
                        boolean isAdded = in.readBoolean();
                        System.out.println(isAdded ? "Thêm thành công" : "Thêm thất bại");
                    }
                    case 3 -> {
                        out.writeUTF("LIST_MOVIES_BY_ACTOR_AND_RELEASED");
                        System.out.print("Nhập actorName: ");
                        out.writeUTF(sc.nextLine());
                        System.out.print("Nhập released: ");
                        out.writeInt(sc.nextInt());
                        sc.nextLine();
                        List<Movie> res = (List<Movie>)in.readObject();
                        res.forEach(System.out::println);
                    }
                    case 4 -> {
                        out.writeUTF("GET_NO_MOVIES_PER_ACTOR_BY_RELEASED_YEAR");
                        System.out.print("Nhập năm từ: ");
                        out.writeInt(sc.nextInt());
                        sc.nextLine();
                        System.out.print("Nhập năm đến: ");
                        out.writeInt(sc.nextInt());
                        sc.nextLine();
                        out.flush();
                        Map<String, Long> res = (Map<String, Long>) in.readObject();
                        res.forEach((k, v) -> System.out.println(k + ": " + v));
                    }
                    case 5 -> {
                        out.writeUTF("SEARCH");
                        System.out.print("Nhập keyword: ");
                        out.writeUTF(sc.nextLine());
                        out.flush();
                        List<Person> res = (List<Person>)in.readObject();
                        res.forEach(System.out::println);
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
