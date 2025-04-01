package iuh.fit;

import java.util.*;
import java.util.stream.Collectors;

public class TrainerManagement {

    public void run() {
        System.out.println("=== Quản lý Huấn luyện viên ===");

        // Quản lý Trainer với LinkedHashMap
        LinkedHashMap<String, Trainer> trainerMap = createTrainerMap();
        System.out.println("\nHuấn luyện viên ban đầu:");
        printTrainerMap(trainerMap);

        // Sắp xếp theo tên (tăng dần)
        LinkedHashMap<String, Trainer> sortedByName = sortByName(trainerMap);
        System.out.println("\nSắp xếp theo tên (tăng dần):");
        printTrainerMap(sortedByName);

        // Sắp xếp theo giờ huấn luyện (giảm dần)
        LinkedHashMap<String, Trainer> sortedByHours = sortByHours(trainerMap);
        System.out.println("\nSắp xếp theo số giờ huấn luyện (giảm dần):");
        printTrainerMap(sortedByHours);

        // Sắp xếp theo tên và giờ (nếu trùng tên)
        LinkedHashMap<String, Trainer> sortedByNameThenHours = sortByNameThenHours(trainerMap);
        System.out.println("\nSắp xếp theo tên, nếu trùng thì theo giờ (giảm dần):");
        printTrainerMap(sortedByNameThenHours);

        // Sắp xếp theo độ dài tên (giảm dần)
        LinkedHashMap<String, Trainer> sortedByNameLengthDesc = sortByNameLengthDesc(trainerMap);
        System.out.println("\nSắp xếp theo độ dài tên (giảm dần):");
        printTrainerMap(sortedByNameLengthDesc);

        // Sắp xếp LinkedHashSet theo thứ tự từ điển ngược
        LinkedHashSet<String> specialties = createSpecialtySet();
        System.out.println("\nChuyên môn ban đầu: " + specialties);

        LinkedHashSet<String> sortedSpecialtiesDesc = sortSpecialtySetDesc(specialties);
        System.out.println("Chuyên môn sau khi sắp xếp ngược: " + sortedSpecialtiesDesc);

        // Sắp xếp LinkedHashSet theo độ dài từ ngắn đến dài
        LinkedHashSet<String> sortedSpecialtyByLength = sortSpecialtyByLength(specialties);
        System.out.println("Chuyên môn sau khi sắp xếp theo độ dài: " + sortedSpecialtyByLength);
    }

    // Tạo Map Huấn luyện viên
    private LinkedHashMap<String, Trainer> createTrainerMap() {
        LinkedHashMap<String, Trainer> map = new LinkedHashMap<>();
        map.put("TR001", new Trainer("John", 120));
        map.put("TR002", new Trainer("Alice", 150));
        map.put("TR003", new Trainer("Bob", 100));
        map.put("TR004", new Trainer("Charlie", 180));
        map.put("TR005", new Trainer("Daisy", 90));
        return map;
    }

    // In danh sách Huấn luyện viên
    private void printTrainerMap(LinkedHashMap<String, Trainer> map) {
        map.forEach((id, trainer) ->
                System.out.println("ID: " + id + ", Tên: " + trainer.name + ", Giờ: " + trainer.trainingHours));
    }

    // Sắp xếp Map theo tên huấn luyện viên (tăng dần)
    private LinkedHashMap<String, Trainer> sortByName(LinkedHashMap<String, Trainer> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(trainer -> trainer.name)))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    // Sắp xếp Map theo số giờ huấn luyện (giảm dần)
    private LinkedHashMap<String, Trainer> sortByHours(LinkedHashMap<String, Trainer> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue((t1, t2) -> t2.trainingHours - t1.trainingHours))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    // Sắp xếp theo tên, nếu trùng thì theo giờ (giảm dần)
    private LinkedHashMap<String, Trainer> sortByNameThenHours(LinkedHashMap<String, Trainer> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(
                        Comparator.comparing((Trainer t) -> t.name).thenComparing((Trainer t) -> -t.trainingHours)
                ))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    // Sắp xếp theo độ dài tên (giảm dần)
    private LinkedHashMap<String, Trainer> sortByNameLengthDesc(LinkedHashMap<String, Trainer> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(
                        Comparator.comparingInt((Trainer t) -> t.name.length()).reversed()
                ))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    // Tạo LinkedHashSet lưu trữ chuyên môn
    private LinkedHashSet<String> createSpecialtySet() {
        return new LinkedHashSet<>(Arrays.asList("Yoga", "Strength Training", "Cardio", "Dance", "Swimming"));
    }

    // Sắp xếp LinkedHashSet theo thứ tự từ điển ngược
    private LinkedHashSet<String> sortSpecialtySetDesc(LinkedHashSet<String> set) {
        return set.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    // Sắp xếp LinkedHashSet theo độ dài
    private LinkedHashSet<String> sortSpecialtyByLength(LinkedHashSet<String> set) {
        return set.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    // Lớp Trainer (Nội bộ trong lớp quản lý)
    class Trainer {
        String name;
        int trainingHours;

        Trainer(String name, int trainingHours) {
            this.name = name;
            this.trainingHours = trainingHours;
        }

        @Override
        public String toString() {
            return name + " (" + trainingHours + " giờ)";
        }
    }
}
