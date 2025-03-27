package iuh.fit.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class MyJson {
    private static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    /**
     *
     * @param cls
     * @return
     * @param <T>
     */
    public static <T> String toJson(T cls){
        return GSON.toJson(cls);
    }

    /**
     * Load data from JSON file
     * @param filePath
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> loadDataFromJson(String filePath, Class<T> clazz) {
        try (FileReader reader = new FileReader(filePath)) {
            Type listType = TypeToken.getParameterized(List.class, clazz).getType();
            return GSON.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}