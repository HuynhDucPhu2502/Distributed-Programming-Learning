package iuh.fit.util;

import iuh.fit.model.Address;
import iuh.fit.model.Student;
import jakarta.json.*;
import jakarta.json.stream.JsonGenerator;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *  Admin 4/15/2025
 *  
**/
public class JsonUtils {

    public static List<Student> listStudentsByClassName(String className, String fileName) {
        List<Student> res = new ArrayList<>();

        try (JsonReader reader = Json.createReader(new FileReader(fileName))) {

            JsonArray classInfoJsonArray = reader.readArray();

            classInfoJsonArray.forEach(classInfoJsonValue -> {
                JsonObject classInfoJsonObject = classInfoJsonValue.asJsonObject();

                String name = classInfoJsonObject.getString("name");

                if (name.equalsIgnoreCase(className)) {
                    JsonArray studentJsonArray = classInfoJsonObject.getJsonArray("students");

                    studentJsonArray.forEach(studentJsonValue -> {
                        JsonObject studentJsonObject = studentJsonValue.asJsonObject();

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
                        res.add(student);
                    });
                }
            });
                    } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }

    public static void writeStudentsToJson(List<Student> students, String fileName) {
        // config
        Map<String, Object> config = Map.of(JsonGenerator.PRETTY_PRINTING, true);
        JsonWriterFactory jsonWriterFactory = Json.createWriterFactory(config);

        try (JsonWriter writer = jsonWriterFactory.createWriter(new FileWriter(fileName))) {

            JsonArrayBuilder studentsJsonArray = Json.createArrayBuilder();

            students.forEach(student -> {
                JsonObjectBuilder studentJsonObject = Json
                        .createObjectBuilder()
                        .add("name", student.getName())
                        .add("age", student.getAge())
                        .add("gpa", student.getGpa());

                Address address = student.getAddress();
                JsonObjectBuilder addressJsonObject = Json
                        .createObjectBuilder()
                        .add("street", address.getStreet())
                        .add("city", address.getCity())
                        .add("state", address.getState())
                        .add("zip", address.getZip());
                studentJsonObject.add("address", addressJsonObject);
                studentsJsonArray.add(studentJsonObject);
            });

            writer.write(studentsJsonArray.build());


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
