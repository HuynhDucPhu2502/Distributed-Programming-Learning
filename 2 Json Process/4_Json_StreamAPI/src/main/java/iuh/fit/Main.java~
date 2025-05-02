package iuh.fit;

import iuh.fit.model.Person;
import iuh.fit.util.JsonUtils;

import java.util.List;

/**
 * Admin 4/7/2025
 * ${DESCRIPTION}
 **/
public class Main {
    public static void main(String[] args) {
        List<Person> people = JsonUtils.fromJson("json/People.json");
        people.forEach(System.out::println);
        JsonUtils.writeToJson(people, "json/people2.json");
    }
}