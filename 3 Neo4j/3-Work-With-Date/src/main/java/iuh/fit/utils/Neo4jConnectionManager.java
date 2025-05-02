package iuh.fit.utils;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Session;

/**
 * Admin 3/2/2025
 **/
public class Neo4jConnectionManager {
    private static final String URI = "bolt://localhost:7687";
    private static final String USERNAME = "neo4j";
    private static final String PASSWORD = "HuynhDucPhu";

    private static Driver driver;

    public static Driver getDriver(String uri, String username, String password) {
        if (driver == null)
            driver = GraphDatabase.driver(uri, AuthTokens.basic(username, password));
        return driver;
    }

    public static Driver getDriver() {
        return getDriver(URI, USERNAME, PASSWORD);
    }

    public static void close() {
        if (driver != null)
            driver.close();
    }


}
