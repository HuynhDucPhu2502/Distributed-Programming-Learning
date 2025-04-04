package iuh.fit;

import iuh.fit.entities.Address;
import iuh.fit.entities.Person;
import iuh.fit.entities.PhoneNumber;
import iuh.fit.utils.JsonUtil;
import net.datafaker.Faker;

import java.util.ArrayList;

/**
 * Admin 1/13/2025
 **/
public class Main {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();

        Faker faker = new Faker();
        for (int i = 0; i< 10; ++i) {
            Person person = new Person();
            person.setFirstName(faker.name().firstName());
            person.setLastName(faker.name().lastName());
            person.setAge(faker.number().numberBetween(18, 60));

            Address address = new Address();
            address.setStreetAddress(faker.address().streetAddress());
            address.setCity(faker.address().city());
            address.setState(faker.address().state());
            address.setPostalCode(Integer.parseInt(faker.address().postcode()));

            int n = faker.number().numberBetween(0, 4);
            ArrayList<PhoneNumber> phoneNumbers = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                PhoneNumber phoneNumber = new PhoneNumber();
                phoneNumber.setType(faker.options().option("Home", "Fax", "Work"));
                phoneNumber.setNumber(faker.phoneNumber().cellPhone());
                phoneNumbers.add(phoneNumber);
            }

            person.setAddress(address);
            person.setPhoneNumbers(phoneNumbers);

            people.add(person);
        }

        people.forEach(System.out::println);

        JsonUtil.toJsonAndWriteToFile(people, "json/People.json");
    }
}
