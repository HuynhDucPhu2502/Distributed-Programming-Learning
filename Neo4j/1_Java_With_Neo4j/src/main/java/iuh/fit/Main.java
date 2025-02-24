package iuh.fit;

import iuh.fit.connection.Neo4jHelper;
import org.neo4j.driver.Session;

/**
 * Admin 2/18/2025
 * ${DESCRIPTION}
 **/
public class Main {
    public static void main(String[] args) {
        try (Session session = Neo4jHelper.getSession()) {
            session.run("CREATE (:Person {name: 'Alice'})");
            session.run("CREATE (:Person {name: 'Bob'})");
            session.run("MATCH (n) RETURN n").list().forEach(System.out::println);
        }




        Neo4jHelper.close();
    }
}