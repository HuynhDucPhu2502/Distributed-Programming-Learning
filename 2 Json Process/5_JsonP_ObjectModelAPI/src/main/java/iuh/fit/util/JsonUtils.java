package iuh.fit.util;

import iuh.fit.model.Address;
import iuh.fit.model.Person;
import iuh.fit.model.PhoneNumber;
import jakarta.json.*;
import jakarta.json.stream.JsonGenerator;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  Admin 4/14/2025
 *  
**/

public class JsonUtils {

    public static List<Person> fromJson(String fileName) {
        List<Person> res = new ArrayList<>();

        try (JsonReader reader = Json.createReader(new FileReader(fileName))) {

            JsonArray peopleJsonArray = reader.readArray();
            peopleJsonArray.forEach(personValue -> {
                JsonObject personJsonObject = personValue.asJsonObject();

                String firstName = personJsonObject.getString("firstName");
                String lastName = personJsonObject.getString("lastName");
                int age = personJsonObject.getInt("age");

                JsonObject addressJsonObject = personJsonObject.getJsonObject("address");
                Address address = new Address(
                        addressJsonObject.getString("streetAddress"),
                        addressJsonObject.getString("city"),
                        addressJsonObject.getString("state"),
                        addressJsonObject.getInt("postalCode")
                );

                List<PhoneNumber> phoneNumbers = new ArrayList<>();
                JsonArray phoneNumbersJsonArray = personJsonObject.getJsonArray("phoneNumbers");
                phoneNumbersJsonArray.forEach(phoneNumberValue -> {
                    JsonObject phoneNumberJsonObject = phoneNumberValue.asJsonObject();
//                    PhoneNumber phoneNumber = new PhoneNumber(
//                            phoneNumberJsonObject.getString("type"),
//                            phoneNumberJsonObject.getString("number")
//                    );
//
//                    phoneNumbers.add(phoneNumber);

                    phoneNumbers.add(
                            new PhoneNumber(
                                    phoneNumberJsonObject.getString("type"),
                                    phoneNumberJsonObject.getString("number")
                            )
                    );

                });

                Person person = new Person(
                        firstName, lastName, age,
                        address, phoneNumbers
                );
                res.add(person);
            });



        } catch (Exception e) {
            e.printStackTrace();
        }


        return res;
    }

    public static void writeToJson(List<Person> peole, String fileName) {
        // config
        Map<String, Object> config = new HashMap<>();
        config.put(JsonGenerator.PRETTY_PRINTING, true);
        JsonWriterFactory jsonWriterFactory = Json.createWriterFactory(config);

        try (JsonWriter writer = jsonWriterFactory.createWriter(new FileWriter(fileName))) {

            JsonArrayBuilder peoleJsonArray = Json.createArrayBuilder();

            peole.forEach(person -> {
                JsonObjectBuilder personJsonObject = Json
                        .createObjectBuilder()
                        .add("firstName", person.getFirstName())
                        .add("lastName", person.getLastName())
                        .add("age", person.getAge());

                Address address = person.getAddress();
                JsonObjectBuilder addressJsonObject = Json
                        .createObjectBuilder()
                        .add("streetAddress", address.getStreetAddress())
                        .add("city", address.getStreetAddress())
                        .add("state", address.getStreetAddress())
                        .add("postalCode", address.getPostalCode());
                personJsonObject.add("address", addressJsonObject);

                List<PhoneNumber> phoneNumbers = person.getPhoneNumbers();
                JsonArrayBuilder phoneNumberJsonArray = Json.createArrayBuilder();
                phoneNumbers.forEach(phoneNumber -> {
                    JsonObjectBuilder phoneNumberJsonObject = Json
                            .createObjectBuilder()
                            .add("type", phoneNumber.getType())
                            .add("number", phoneNumber.getNumber());

                    phoneNumberJsonArray.add(phoneNumberJsonObject);
                });
                personJsonObject.add("phoneNumbers", phoneNumberJsonArray);
                peoleJsonArray.add(personJsonObject);

            });

            writer.write(peoleJsonArray.build());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}

