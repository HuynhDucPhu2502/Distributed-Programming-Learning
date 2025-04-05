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
        List<ClassInfo> classInfos = JsonUtils.fromJson("json/classes.json");
        classInfos.forEach(System.out::println);
        JsonUtils.writeJsonToFile("json/classes2.json", classInfos);
    }
}