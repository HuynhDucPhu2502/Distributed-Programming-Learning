package iuh.fit;

import models.Movie;
import services.MovieService;
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

        ShowService showService = (ShowService) registry.lookup("showService") ;
        MovieService movieService = (MovieService) registry.lookup("movieService");

//        showService
//                .listShowsByCurrentDateAndDirector("Anthony Russo")
//                .forEach(System.out::println);

        try (Scanner sc = new Scanner(System.in)) {

            while (true) {
                System.out.println("1. Liệt kê buổi chiếu phim trong ngày hiện tại theo tên đạo diễn");
                System.out.println("2. Cập nhật ngày giờ chiếu phim cho buổi chiếu phim chưa ai đặt vé");
                System.out.println("3. Thêm bộ phim mới");
                System.out.println("4. Thoát");
                System.out.print("Nhập lựa chọn: ");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1 -> {
                        System.out.print("Nhập tên đạo diễn: ");
                        String director = sc.nextLine();
                        showService
                                .listShowsByCurrentDateAndDirector(director)
                                .forEach(System.out::println);
                    }
                    case 2 -> {
                        System.out.print("Nhập mã buổi chiếu phim: ");
                        String showId = sc.nextLine();

                        try {
                            System.out.print("Nhập ngày: ");
                            int day = Integer.parseInt(sc.nextLine());
                            System.out.print("Nhập tháng: ");
                            int month = Integer.parseInt(sc.nextLine());
                            System.out.print("Nhập năm: ");
                            int year = Integer.parseInt(sc.nextLine());
                            System.out.print("Nhập giờ: ");
                            int hour = Integer.parseInt(sc.nextLine());

                            LocalDateTime newShowDatetime = LocalDateTime.of(
                                    year,
                                    month,
                                    day,
                                    hour,
                                    0
                            );

                            System.out.println(showService.updateShowDateTime(
                                    showId,
                                    newShowDatetime
                            ));

                        } catch (Exception e) {
                            System.out.println("Dữ liệu không hợp lệ");
                        }

                    }
                    case 3 -> {
                        try {
                            System.out.print("Nhập mã phim: ");
                            String id = sc.nextLine();
                            System.out.print("Nhập tên phim: ");
                            String title = sc.nextLine();
                            System.out.print("Nhập thời lượng: ");
                            int duration = Integer.parseInt(sc.nextLine());
                            System.out.print("Nhập năm phát hành: ");
                            int releaseYear = Integer.parseInt(sc.nextLine());

                            Movie movie = new Movie();
                            movie.setId(id);
                            movie.setTitle(title);
                            movie.setDuration(duration);
                            movie.setReleaseYear(releaseYear);

                            System.out.println(movieService.addMovie(movie));
                        } catch (Exception e) {
                            System.out.println("Dữ liệu không hợp lệ");
                        }
                    }
                    case 4 -> System.exit(0);
                }

            }

        }



    }
}
