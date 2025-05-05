package iuh.fit;

import service.DepartmentService;
import service.StaffService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *  Admin 5/5/2025
 *  
**/public class Client {


    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("Admin-PC", 8080);

        StaffService staffService = (StaffService) registry.lookup("staffService");
        DepartmentService departmentService = (DepartmentService)  registry.lookup("departmentService");


        departmentService
                .countStaffByDepartment()
                .forEach((k, v) -> System.out.println(k.getName() + ":" + v));

    }

}
