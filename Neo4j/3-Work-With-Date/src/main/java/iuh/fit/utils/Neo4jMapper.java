package iuh.fit.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.neo4j.driver.types.Node;

import java.util.Map;

/**
 * Admin 3/2/2025
 **/
public class Neo4jMapper {
    private static final ObjectMapper OBJECT_MAPPER =
            new ObjectMapper().registerModule(new JavaTimeModule());


    public static <T> T mapNodeToClass(Node node, Class<T> className) {
        try {
            Map<String, Object> map = node.asMap();
            String json = OBJECT_MAPPER.writeValueAsString(map);
            return OBJECT_MAPPER.readValue(json, className);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<String, Object> mapClassToMap(Object object, String... excludeKeys) {
        try {
            Map<String, Object> map = OBJECT_MAPPER.convertValue(object, Map.class);
            for (String key: excludeKeys) map.remove(key);
            return map;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
