package iuh.fit;

import com.google.gson.Gson;
import iuh.fit.models.Course;
import iuh.fit.models.Department;
import org.neo4j.driver.AuthToken;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.types.Node;

import java.util.Map;

public class AppUtils {

    private static final Gson GSON = new Gson();
    public static Driver getDriver() {
        final String dbUri = "neo4j://localhost:7687";
        final String dbUser = "neo4j";
        final String dbPassword = "HuynhDucPhu";
        AuthToken authTokens = AuthTokens.basic(dbUser, dbPassword);

        return GraphDatabase.driver(dbUri, authTokens);
    }

    public static <T> T toObject(Node node, Class<T> cls) {
        Map<String, Object> objectMapper = node.asMap();
        String json = GSON.toJson(objectMapper);

        return GSON.fromJson(json, cls);
    }
}
