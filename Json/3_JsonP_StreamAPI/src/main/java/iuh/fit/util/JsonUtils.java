package iuh.fit.util;

import iuh.fit.model.Address;
import iuh.fit.model.ClassInfo;
import iuh.fit.model.Student;
import jakarta.json.Json;
import jakarta.json.stream.JsonParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *  Admin 4/7/2025
 *  
**/

public class JsonUtils {

    public static List<ClassInfo> fromJson(String fileName) {
        List<ClassInfo> res = new ArrayList<>();

        try (JsonParser parser = Json.createParser(new FileReader(fileName))) {
            ClassInfo classInfo = null;
            List<Student> students = null;

            Student student = null;
            Address address = null;

            String key = "";
            String currentObj = "";


            while (parser.hasNext()) {
                JsonParser.Event event = parser.next();

                switch (event) {
                    case START_ARRAY -> {
                        if (key.equalsIgnoreCase("students")) {
                            students = new ArrayList<>();
                        }
                    }

                    case START_OBJECT -> { // {
                        if (classInfo == null) {
                            classInfo = new ClassInfo();
                            currentObj = "classinfo";
                        } else if (student == null) {
                            student = new Student();
                            currentObj = "student";
                        } else if (address == null) {
                            address = new Address();
                            currentObj = "address";
                        }
                    }
                    case END_OBJECT -> { // }
                        if (address != null) {
                            student.setAddress(address);
                            address = null;
                            currentObj = "student";
                        } else if (student != null) {
                            students.add(student);
                            student = null;
                            currentObj = "classinfo";
                        } else if (classInfo != null) {
                            classInfo.setStudents(students);
                            res.add(classInfo);
                            classInfo = null;
                            students = null;
                        }

                    }
                    case KEY_NAME -> {
                        key = parser.getString();
                    }
                    case VALUE_STRING -> {
                        String value = parser.getString();

                        switch (key) {
                            case "name" -> {
                                if (currentObj.equalsIgnoreCase("classinfo"))
                                    classInfo.setName(value);
                                else student.setName(value);
                            }
                            case "teacher" -> classInfo.setTeacher(value);
                            case "start_time" -> classInfo.setStartTime(value);
                            case "end_time" -> classInfo.setEndTime(value);
                            case "street" -> address.setStreet(value);
                            case "city" -> address.setCity(value);
                            case "state" -> address.setState(value);
                            case "zip" -> address.setZip(value);
                        }
                    }
                    case VALUE_NUMBER -> {
                        switch (key) {
                            case "room" -> classInfo.setRoom(parser.getInt());
                            case "age" -> student.setAge(parser.getInt());
                            case "gpa" -> student.setGpa(parser.getBigDecimal().doubleValue());
                        }
                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }

}
