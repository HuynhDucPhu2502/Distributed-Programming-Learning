package iuh.fit.connection;

import org.neo4j.driver.*;

/**
 * Admin 2/18/2025
 **/
public class Neo4jHelper {
    // THÔNG TIN KẾT NỐI
    private static final String NEO4J_URI = "bolt://localhost:7687";
    private static final String USER = "neo4j";
    private static final String PASSWORD = "HuynhDucPhu";
    private static final String DATABASE_NAME = "Neo4j";

    // DRIVER
    public static final Driver driver= GraphDatabase.driver(NEO4J_URI, AuthTokens.basic(USER, PASSWORD));

    public static Session getSession() {
        return driver.session(SessionConfig.forDatabase(DATABASE_NAME));
    }

    public static void close() {
        driver.close();
    }

}
