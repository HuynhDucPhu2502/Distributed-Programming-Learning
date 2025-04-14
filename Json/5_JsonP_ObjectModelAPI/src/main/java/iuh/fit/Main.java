package iuh.fit;

import iuh.fit.model.Person;
import iuh.fit.util.JsonUtils;

import java.util.List;

/**
 *  Admin 4/14/2025
 *  
**/
public class Main {
    public static void main(String[] args) {
        List<Person> res = JsonUtils.fromJson("json/People.json");
        res.forEach(System.out::println);
        JsonUtils.writeToJson(res, "json/People2.json");
    }
}
