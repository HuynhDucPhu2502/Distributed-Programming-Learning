package iuh.fit;

import models.Movie;
import services.ShowService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * Admin 5/14/2025
 **/
public class Client {

    public static void main(String[] args) throws Exception {

        Registry registry = LocateRegistry.getRegistry("Admin-PC", 8080);

        ShowService showService = (ShowService) registry.lookup("showService");

//        showService.listShowsByCurrentDateAndDirector("Bong Joon-ho")
//                .forEach(System.out::println);

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("===========================================");
                System.out.println("1. Liệt kê buổi chiếu phim trong ngày hiện tại theo tên đạo diễn");
                System.out.println("2. Cập nhật ngày giờ chiếu phim cho buổi chiếu phim chưa ai đặt vé");
                System.out.println("3. Thêm bộ phim mới");
                System.out.println("4. Thoát");
                System.out.println("===========================================");
                System.out.print("Nhập lựa chọn của bạn: ");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1 -> {
                        System.out.print("Nhập tên đạo diễn: ");
                        String directorName = sc.nextLine();
                        showService.listShowsByCurrentDateAndDirector(directorName)
                                .forEach(System.out::println);
                    }
                    case 2 -> {
                        System.out.print("Nhập mã show: ");
                        String showId = sc.nextLine();

                        System.out.print("Nhập ngày chiếu: ");
                        int day = Integer.parseInt(sc.nextLine());
                        System.out.print("Nhập tháng chiếu: ");
                        int month = Integer.parseInt(sc.nextLine());
                        System.out.print("Nhập năm chiếu: ");
                        int year = Integer.parseInt(sc.nextLine());
                        System.out.print("Nhập giờ: ");
                        int hour = Integer.parseInt(sc.nextLine());

                        try {
                            LocalDateTime newShowTime = LocalDateTime.of(year, month, day, hour, 0);
                            System.out.println(showService.updateShowDateTime(showId, newShowTime));
                        } catch (Exception e) {
                            System.out.println("Ngày chiếu không hợp lệ");
                        }

                    }
                    case 3 -> {
                        System.out.print("Nhập mã phim: ");
                        String movieId = sc.nextLine();

                        System.out.print("Nhập tên phim: ");
                        String title = sc.nextLine();

                        System.out.print("Nhập năm phát hành: ");
                        int releaseYear = Integer.parseInt(sc.nextLine());

                        System.out.print("Nhập thời lượng: ");
                        int duration = Integer.parseInt(sc.nextLine());

                        Movie movie = new Movie();
                        movie.setId(movieId);
                        movie.setTitle(title);
                        movie.setReleaseYear(releaseYear);
                        movie.setDuration(duration);

                        System.out.println(showService.addMovie(movie));
                    }
                    case 4 -> System.exit(0);
                }
            }
        }

    }
}
