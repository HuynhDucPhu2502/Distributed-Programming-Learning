package iuh.fit.util;

import org.neo4j.driver.*;

/**
 * Admin 3/28/2025
 **/
public class AppUtils {
    private static final String DB_NAME = "neo4j";
    private static final String USERNAME = "neo4j";
    private static final String PASSWORD = "HuynhDucPhu";
    private static final String URI = "neo4j://localhost:7687";

    private static Driver driver;

    public static Driver getDriver() {
        if (driver == null)
            driver = GraphDatabase.driver(URI, AuthTokens.basic(USERNAME, PASSWORD));
        return driver;
    }

    public static Session getSession() {
        return getDriver().session(SessionConfig.forDatabase(DB_NAME));
    }


}
