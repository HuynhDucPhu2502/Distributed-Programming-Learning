package iuh.fit;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.registry.LocateRegistry;

/**
 * Admin 3/31/2025
 **/
public class RMIServer {
    public static void main(String[] args) throws Exception {
        try {
            Context context = new InitialContext();
            ICal cal = new CalcImpl(); // Java Remote Object

            LocateRegistry.createRegistry(9090);
            context.bind("rmi://192.168.29.117:9090/cal", cal);

            System.out.println("READY");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
