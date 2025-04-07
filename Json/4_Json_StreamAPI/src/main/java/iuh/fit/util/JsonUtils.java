package iuh.fit.util;

import iuh.fit.model.Address;
import iuh.fit.model.Person;
import iuh.fit.model.Phonenumber;
import jakarta.json.Json;
import jakarta.json.stream.JsonGenerator;
import jakarta.json.stream.JsonGeneratorFactory;
import jakarta.json.stream.JsonParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

/**
 * Admin 4/7/2025
 **/
public class JsonUtils {

    public static List<Person> fromJson(String fileName) {
        List<Person> res = new ArrayList<>();

        try (JsonParser parser = Json.createParser(new FileReader(fileName))) {
            Person person = null;
            Address address = null;
            List<Phonenumber> phonenumbers = null;

            Phonenumber phonenumber = null;

            String key = "";


            while (parser.hasNext()) {
                JsonParser.Event event = parser.next();

                switch (event) {
                    case START_ARRAY -> {
                        if (key.equalsIgnoreCase("phoneNumbers")) {
                            phonenumbers = new ArrayList<>();
                        }
                    }

                    case START_OBJECT -> {
                        if (person == null) {
                            person = new Person();
                        } else if (address == null
                                && key.equalsIgnoreCase("address")) {
                            address = new Address();
                        } else if (phonenumber == null) {
                            phonenumber = new Phonenumber();
                        }

                    }
                    case END_OBJECT -> {
                        if (address != null) {
                            person.setAddress(address);
                            address = null;
                        } else if (phonenumber != null) {
                            phonenumbers.add(phonenumber);
                            phonenumber = null;
                        } else if (person != null) {
                            person.setPhoneNumbers(phonenumbers);
                            res.add(person);
                            phonenumbers =  null;
                            person = null;
                        }

                    }
                    case KEY_NAME -> {
                        key = parser.getString();
                    }
                    case VALUE_STRING -> {
                        String value = parser.getString();

                        switch (key) {
                            case "firstName" -> person.setFirstName(value);
                            case "lastName" -> person.setLastName(value);
                            case "streetAddress" -> address.setStreetAddress(value);
                            case "city" -> address.setCity(value);
                            case "state" -> address.setState(value);
                            case "type" -> phonenumber.setType(value);
                            case "number" -> phonenumber.setNumber(value);
                        }
                    }
                    case VALUE_NUMBER -> {
                        int value = parser.getInt();

                        switch (key) {
                            case "age" -> person.setAge(value);
                            case "postalCode" -> address.setPostalCode(value);
                        }
                    }
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }

    public static void writeToJson(List<Person> people, String fileName) {
        // config
        Map<String, Object> config = new HashMap<>();
        config.put(JsonGenerator.PRETTY_PRINTING, true);
        JsonGeneratorFactory jsonGeneratorFactory = Json.createGeneratorFactory(config);

        try (JsonGenerator jsonGenerator = jsonGeneratorFactory.createGenerator(new FileWriter(fileName))) {
            jsonGenerator.writeStartArray();

            people.forEach(person -> {
                jsonGenerator.writeStartObject();

                jsonGenerator.write("firstName", person.getFirstName());
                jsonGenerator.write("lastName", person.getLastName());
                jsonGenerator.write("age", person.getAge());

                Address address = person.getAddress();
                jsonGenerator.writeStartObject("address");
                jsonGenerator.write("streetAddress", address.getStreetAddress());
                jsonGenerator.write("city", address.getCity());
                jsonGenerator.write("state", address.getStreetAddress());
                jsonGenerator.write("postalCode", address.getPostalCode());
                jsonGenerator.writeEnd();

                List<Phonenumber> phonenumbers = person.getPhoneNumbers();
                jsonGenerator.writeStartArray("phoneNumbers");
                phonenumbers.forEach(phoneNumber -> {
                    jsonGenerator.writeStartObject();
                    jsonGenerator.write("type", phoneNumber.getType());
                    jsonGenerator.write("number", phoneNumber.getNumber());
                    jsonGenerator.writeEnd();
                });
                jsonGenerator.writeEnd();


                jsonGenerator.writeEnd();
            });

            jsonGenerator.writeEnd();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
