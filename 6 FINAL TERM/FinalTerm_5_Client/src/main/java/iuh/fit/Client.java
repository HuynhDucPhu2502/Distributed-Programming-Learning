package iuh.fit;

import model.Question;
import model.enums.Level;
import service.QuestionService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 * Admin 5/10/2025
 **/
public class Client {
    public static void main(String[] args) throws Exception {

        Registry registry = LocateRegistry.getRegistry("Admin-PC", 8080);

        QuestionService questionService = (QuestionService) registry.lookup("questionService");

//        questionService.listQuestionsByLevelAndCategory("mo", Level.EASY)
//                .forEach(System.out::println);


        try (Scanner sc = new Scanner(System.in)) {

            while (true) {
                System.out.println("================================");
                System.out.println("1. Liệt kê danh sách các câu hỏi dựa trên độ khó của câu hỏi và thuộc về một chủ đề");
                System.out.println("2. Thống kê số lượng câu hỏi theo mức độ khó của câu hỏi");
                System.out.println("3. Thêm một câu hỏi (question) mới vào một chủ đề (category)");
                System.out.println("4. Thoát");
                System.out.println("================================");
                System.out.print("Chọn công việc của bạn: ");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1 -> {
                        System.out.print("Nhập category name: ");
                        String categoryName = sc.nextLine();

                        System.out.println("1. EASY, 2. MEDIUM, 3. HARD (điền số)");
                        System.out.print("Chọn level: ");
                        Level level = null;
                        int choiceLevel = Integer.parseInt(sc.nextLine());
                        switch (choiceLevel) {
                            case 1 -> level = Level.EASY;
                            case 2 -> level = Level.MEDIUM;
                            case 3 -> level = Level.HARD;
                        }

                        if (level != null) {
                            questionService.listQuestionsByLevelAndCategory(categoryName, level)
                                    .forEach(System.out::println);
                        } else {
                            System.out.println("Level không phù hợp");
                        }

                    }

                    case 2 -> {
                        System.out.print("Nhập quizid: ");
                        String quizId = sc.nextLine();

                        questionService.countQuestionsByLevelInQuiz(quizId)
                                .forEach((k, v) -> System.out.println(k + ": " + v));
                    }

                    case 3 -> {
                        Question question = new Question();

                        System.out.print("Nhập id: ");
                        question.setId(sc.nextLine());

                        System.out.print("Nhập quest text: ");
                        question.setQuestionText(sc.nextLine());

                        System.out.print("Nhập category id:");
                        String categoryId = sc.nextLine();

                        System.out.println(questionService.addQuestionToCategory(question, categoryId));
                    }

                    case 4 -> System.exit(0);

                }

            }



        }





    }
}
