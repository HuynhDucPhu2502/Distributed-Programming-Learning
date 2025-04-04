package iuh.fit.utils;

import iuh.fit.entities.Address;
import iuh.fit.entities.Person;
import iuh.fit.entities.PhoneNumber;
import jakarta.json.*;
import jakarta.json.stream.JsonGenerator;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Admin 1/13/2025
 **/
public class JsonUtil {
    public static void main(String[] args) {
        Person p = fromJson("json/Person.json");
        System.out.println(p);
    }

    public static Person fromJson(String fileName) {
        Person p;

        try (JsonReader reader = Json.createReader(new FileReader(fileName))) {
            JsonObject jsonObject = reader.readObject();
            if (jsonObject != null) {
                p = new Person();
                p.setFirstName(jsonObject.getString("firstName"));
                p.setLastName(jsonObject.getString("lastName"));
                p.setAge(jsonObject.getInt("age"));

                JsonObject addressObject = jsonObject.getJsonObject("address");
                if (addressObject != null) {
                    Address address = new Address(
                            addressObject.getString("streetAddress"),
                            addressObject.getString("city"),
                            addressObject.getString("state"),
                            addressObject.getInt("postalCode")
                    );
                    p.setAddress(address);
                }

                JsonArray phoneArray = jsonObject.getJsonArray("phoneNumbers");
                if (phoneArray != null) {
                    List<PhoneNumber> phoneNumbers = phoneArray.stream()
                            .map(x -> (JsonObject) x)
                            .map(x -> new PhoneNumber(
                                    x.getString("type"),
                                    x.getString("number")
                            ))
                            .toList();
                    p.setPhoneNumbers((ArrayList<PhoneNumber>) phoneNumbers);
                }

                return p;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void toJsonAndWriteToFile(ArrayList<Person> people, String fileName) {
        Map<String, Object> config = new HashMap<>();
        config.put(JsonGenerator.PRETTY_PRINTING, true);

        JsonWriterFactory writerFactory = Json.createWriterFactory(config);

        try (JsonWriter writer = writerFactory.createWriter(new FileWriter(fileName))) {
            JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
            people.stream()
                    .map(person -> {
                        JsonObjectBuilder personBuilder = Json.createObjectBuilder()
                                .add("firstName", person.getFirstName())
                                .add("lastName", person.getLastName())
                                .add("age", person.getAge());

                        Address address = person.getAddress();
                        if (address != null)
                            personBuilder.add("address", Json.createObjectBuilder()
                                    .add("streetAddress", address.getStreetAddress())
                                    .add("city", address.getCity())
                                    .add("state", address.getState())
                                    .add("postalCode", address.getPostalCode()));


                        ArrayList<PhoneNumber> phoneNumbers = person.getPhoneNumbers();
                        if (phoneNumbers != null) {
                            JsonArrayBuilder phoneArrayBuilder = Json.createArrayBuilder();
                            phoneNumbers.forEach(phoneNumber -> phoneArrayBuilder.add(Json.createObjectBuilder()
                                    .add("type", phoneNumber.getType())
                                    .add("number", phoneNumber.getNumber()).build()));
                            personBuilder.add("phoneNumbers", phoneArrayBuilder.build());
                        }


                        return personBuilder;
                    })
                    .forEach(arrayBuilder::add);

            writer.writeArray(arrayBuilder.build());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
