import service.DepartmentService;
import service.StaffService;
import service.implement.DepartmentServiceImpl;
import service.implement.StaffServiceImpl;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.registry.LocateRegistry;

/**
 * Admin 5/5/2025
 **/
public class Server {

    public static void main(String[] args) throws Exception {

        Context context = new InitialContext();
        LocateRegistry.createRegistry(8080);

        DepartmentService departmentService = new DepartmentServiceImpl();
        StaffService staffService = new StaffServiceImpl();

        context.bind("rmi://Admin-PC:8080/departmentService", departmentService);
        context.bind("rmi://Admin-PC:8080/staffService", staffService);



        System.out.println("RMI server started");
    }
}
