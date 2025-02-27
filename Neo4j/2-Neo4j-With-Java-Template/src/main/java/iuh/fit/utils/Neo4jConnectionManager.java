package iuh.fit.utils;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Session;

/**
 * Admin 2/27/2025
 **/
public class Neo4jConnectionManager {
    public static final String URI = "bolt://localhost:7687";
    public static final String USER = "neo4j";
    public static final String PASSWORD = "HuynhDucPhu";

    private static Driver driver;

    public static Driver getDriver() {
        if (driver == null)
            driver = GraphDatabase.driver(URI, AuthTokens.basic(USER, PASSWORD));
        return driver;
    }

    public static Session getSession() {
        return getDriver().session();
    }

    public static void closeDriver() {
        if (driver != null) driver.close();
    }


}
