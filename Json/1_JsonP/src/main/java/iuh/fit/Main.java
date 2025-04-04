package iuh.fit;

import iuh.fit.model.ClassInfo;
import iuh.fit.util.JsonUtils;

import java.util.List;

/**
 * Admin 4/4/2025
 * ${DESCRIPTION}
 **/
public class Main {
    public static void main(String[] args) {
        List<ClassInfo> classes = JsonUtils.fromJson("json/classes.json");
        classes.forEach(System.out::println);
        JsonUtils.toJsonAndWriteToFile(classes, "json/classes2.json");
    }
}