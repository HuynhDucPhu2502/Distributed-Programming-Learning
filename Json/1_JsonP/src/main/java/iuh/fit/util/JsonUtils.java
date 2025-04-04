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
 * Admin 4/4/2025
 **/
public class JsonUtils {
    // Huynh Duc Phu was here!!!!


    // fromJson từ json map qua POJO Class (Java Class)
    public static List<ClassInfo> fromJson(String fileName) {
        List<ClassInfo> res = new ArrayList<>();

        try (JsonReader reader = Json.createReader(new FileReader(fileName))) {
            // Cấp 0
            JsonArray classInfoJsonArray = reader.readArray();

            classInfoJsonArray.forEach(classInfoValue -> {
                JsonObject classInfoObject = classInfoValue.asJsonObject();

                String name = classInfoObject.getString("name");
                String teacher = classInfoObject.getString("teacher");
                int room = classInfoObject.getInt("room");
                String startTime = classInfoObject.getString("start_time");
                String endTime = classInfoObject.getString("end_time");

                List<Student> students = new ArrayList<>();
                JsonArray studentJsonArray = classInfoObject.getJsonArray("students");
                studentJsonArray.forEach(studentValue -> {
                    JsonObject studentObject = studentValue.asJsonObject();

                    String studentName = studentObject.getString("name");
                    int age = studentObject.getInt("age");
                    double gpa = studentObject.getJsonNumber("gpa").doubleValue();
                    JsonObject addressObject = studentObject.getJsonObject("address");

                    Address address = new Address(
                            addressObject.getString("street"),
                            addressObject.getString("city"),
                            addressObject.getString("state"),
                            addressObject.getString("zip")
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


    // toJsonAndWriteToFile từ java ra json file
    public static void toJsonAndWriteToFile(List<ClassInfo> classInfos, String fileName) {
        // config
        Map<String, Object> config = new HashMap<>();
        config.put(JsonGenerator.PRETTY_PRINTING, true);
        JsonWriterFactory jsonWriterFactory = Json.createWriterFactory(config);

        try (JsonWriter writer = jsonWriterFactory.createWriter(new FileWriter(fileName))) {
            // Cấp 0
            JsonArrayBuilder classInfoJsonArray = Json.createArrayBuilder();

            classInfos.forEach(classInfoValue -> {
                JsonObjectBuilder classInfoObject = Json
                        .createObjectBuilder()
                        .add("name", classInfoValue.getName())
                        .add("teacher", classInfoValue.getTeacher())
                        .add("room", classInfoValue.getRoom())
                        .add("start_time", classInfoValue.getStartTime())
                        .add("end_time", classInfoValue.getEndTime());

                // Student Array Object
                // ===============================================================================
                JsonArrayBuilder studentJsonArray = Json.createArrayBuilder();
                classInfoValue.getStudents().forEach(studentInfoValue -> {
                    // Student Object
                    // ===========================================================
                    JsonObjectBuilder studentObject = Json
                            .createObjectBuilder()
                            .add("name", studentInfoValue.getName())
                            .add("age", studentInfoValue.getName())
                            .add("gpa", studentInfoValue.getName());

                    // Address Object
                    // =====================================
                    Address address = studentInfoValue.getAddress();
                    JsonObjectBuilder addressObject = Json
                            .createObjectBuilder()
                            .add("street", address.getStreet())
                            .add("city", address.getCity())
                            .add("state", address.getState())
                            .add("zip", address.getZip());
                    // =====================================

                    studentObject.add("address", addressObject);
                    // ===========================================================


                    studentJsonArray.add(studentObject);
                });
                // ===============================================================================

                classInfoObject.add("students", studentJsonArray);
                classInfoJsonArray.add(classInfoObject);
            });


            writer.writeArray(classInfoJsonArray.build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
