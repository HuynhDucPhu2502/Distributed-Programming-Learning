package iuh.fit;

import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * Admin 3/31/2025
 * ${DESCRIPTION}
 **/
public class Main {
    public static void main(String[] args) throws Exception {
        Context context = new InitialContext();

        ICal cal = (ICal) context.lookup("rmi://192.168.29.117:9090/cal");

        int sub = cal.sub(100, 50);
        int sum = cal.sum(100, 50);
        System.out.println("Sub: " + sub);
        System.out.println("Sum: " + sum);
    }
}