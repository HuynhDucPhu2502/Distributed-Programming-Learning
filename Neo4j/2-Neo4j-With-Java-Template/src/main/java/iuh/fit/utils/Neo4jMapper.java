package iuh.fit.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.neo4j.driver.types.Node;

import java.util.Map;

/**
 * Admin 2/27/2025
 **/
public class Neo4jMapper {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static <T> T mapNodeToClass(Node node, Class<T> className) {
        if (node == null || className == null)
            throw new IllegalArgumentException("Không thể convert");

        try {
            Map<String, Object> properties = node.asMap();
            String json = OBJECT_MAPPER.writeValueAsString(properties);
            return OBJECT_MAPPER.readValue(json, className);
        } catch (Exception e) {
            throw new RuntimeException("Không thể convert qua Class");
        }
    }

    public static Map<String, Object> mapClassToJson(Object object) {
        if (object == null)
            throw new IllegalArgumentException("Không thể convert");

        try {
            return OBJECT_MAPPER.convertValue(object, Map.class);
        } catch (Exception e) {
            throw new RuntimeException("Không thể convert qua Json");
        }
    }

}
