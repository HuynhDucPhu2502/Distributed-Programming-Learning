package iuh.fit.util;

import org.neo4j.driver.*;

/**
 * Admin 3/30/2025
 **/
public class AppUtils {
    private final static String DB_NAME = "neo4j";
    private final static String USERNAME = "neo4j";
    private final static String PASSWORD = "HuynhDucPhu";
    private final static String URI = "neo4j://localhost:7687";

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
