package iuh.fit.util;

import iuh.fit.model.Address;
import iuh.fit.model.ClassInfo;
import iuh.fit.model.Student;
import jakarta.json.*;
import jakarta.json.stream.JsonGenerator;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  Admin 4/4/2025
 *  
**/


public class JsonUtils {

    public static List<ClassInfo> fromJson(String fileName) {
        List<ClassInfo> res = new ArrayList<>();

        try (JsonReader reader = Json.createReader(new FileReader(fileName))) {
            JsonArray classInfoJsonArray = reader.readArray();

            classInfoJsonArray.forEach(classInfoValue -> {
                JsonObject classInfoJsonObject = classInfoValue.asJsonObject();

                String name = classInfoJsonObject.getString("name");
                String teacher = classInfoJsonObject.getString("teacher");
                int room = classInfoJsonObject.getInt("room");
                String startTime = classInfoJsonObject.getString("start_time");
                String endTime = classInfoJsonObject.getString("end_time");

                List<Student> students = new ArrayList<>();
                JsonArray studentsJsonArray = classInfoJsonObject.getJsonArray("students");
                studentsJsonArray.forEach(studentValue -> {
                    JsonObject studentJsonObject = studentValue.asJsonObject();

                    String studentName = studentJsonObject.getString("name");
                    int age = studentJsonObject.getInt("age");
                    double gpa = studentJsonObject.getJsonNumber("gpa").doubleValue();

                    JsonObject addressJsonObject = studentJsonObject.getJsonObject("address");
                    Address address = new Address(
                            addressJsonObject.getString("street"),
                            addressJsonObject.getString("city"),
                            addressJsonObject.getString("state"),
                            addressJsonObject.getString("zip")
                    );

                    Student student = new Student(studentName, age, gpa, address);
                    students.add(student);

                });

                ClassInfo classInfo = new ClassInfo(
                        name, teacher, room,
                        startTime, endTime, students
                );

                res.add(classInfo);


            });


        } catch (Exception e) {
            e.printStackTrace();
        }



        return res;
    }

    public static void writeJsonToFile(String fileName, List<ClassInfo> classInfos) {
        // Config
        Map<String, Object> config = new HashMap<>();
        config.put(JsonGenerator.PRETTY_PRINTING, true);
        JsonWriterFactory jsonWriterFactory = Json.createWriterFactory(config);

        try (JsonWriter writer = jsonWriterFactory.createWriter(new FileWriter(fileName))) {
            JsonArrayBuilder classInfoJsonArray = Json.createArrayBuilder();

            classInfos.forEach(classInfoValue -> {
                JsonObjectBuilder classInfoObject = Json
                        .createObjectBuilder()
                        .add("name", classInfoValue.getName())
                        .add("teacher", classInfoValue.getTeacher())
                        .add("room", classInfoValue.getRoom())
                        .add("start_time", classInfoValue.getStartTime())
                        .add("end_time", classInfoValue.getEndTime());

                JsonArrayBuilder studentsJsonArray = Json.createArrayBuilder();

                classInfoValue.getStudentList().forEach(studentValue -> {
                    JsonObjectBuilder studentObject = Json
                            .createObjectBuilder()
                            .add("name", studentValue.getName())
                            .add("age", studentValue.getAge())
                            .add("gpa", studentValue.getGpa());

                    Address address = studentValue.getAddress();
                    JsonObject addressObject = Json
                            .createObjectBuilder()
                            .add("street", address.getStreet())
                            .add("city", address.getCity())
                            .add("state", address.getState())
                            .add("zip", address.getZip())
                            .build();

                    studentObject.add("address", addressObject);

                    studentsJsonArray.add(studentObject);
                });

                classInfoObject.add("students", studentsJsonArray);
                classInfoJsonArray.add(classInfoObject);
            });

            writer.writeArray(classInfoJsonArray.build());


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
