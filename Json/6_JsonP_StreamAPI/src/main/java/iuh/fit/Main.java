package iuh.fit;

import iuh.fit.model.Flight;
import iuh.fit.util.JsonUtils;

import java.util.List;

/**
 *  Admin 4/14/2025
 *  
**/
public class Main {
    public static void main(String[] args) {
        List<Flight> res = JsonUtils.fromJson("json/flights.json");
        res.forEach(System.out::println);
        JsonUtils.writeToJson(res, "json/flights2.json");
    }
}
