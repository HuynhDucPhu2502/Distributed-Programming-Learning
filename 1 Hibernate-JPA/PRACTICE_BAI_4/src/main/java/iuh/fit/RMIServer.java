package iuh.fit;



import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.registry.LocateRegistry;

public class RMIServer {
    public static void main(String[] args) throws Exception{
        Context context = new InitialContext();



        LocateRegistry.createRegistry(9090);

//        context.bind("rmi://Admin-PC:9090/studentDAO", studentDAO);

        System.out.println("Server is ready!!!");

    }
}
