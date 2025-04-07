package iuh.fit;

import iuh.fit.model.ClassInfo;
import iuh.fit.util.JsonUtils;

import java.util.List;

/**
 * Admin 4/6/2025
 * ${DESCRIPTION}
 **/
public class Main {
    public static void main(String[] args) {
        List<ClassInfo> res = JsonUtils.fromJson("json/classes.json");
        res.forEach(System.out::println);
    }
}