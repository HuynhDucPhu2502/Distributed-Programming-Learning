package iuh.fit;

import iuh.fit.models.Employee;
import iuh.fit.models.EmployeeStatus;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import net.datafaker.Faker;

import java.util.stream.IntStream;

/**
 * Admin 2/8/2025
 * ${DESCRIPTION}
 **///TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mariadb");

        Faker faker = new Faker();

        try (
                EntityManager em = emf.createEntityManager();
                ) {
            em.getTransaction().begin();

            IntStream.range(0, 5).forEach(i -> {
                Employee employee = new Employee();
                employee.setName("Employee " + i);
                employee.setEmployeeId("EMP" + i);
                employee.setEmployeeStatus(faker.options().option(EmployeeStatus.values()));
                em.persist(employee);
            });

            em.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        try (
                EntityManager em = emf.createEntityManager();
        ) {
            em.getTransaction().begin();

            Employee employee = em.find(Employee.class, 1L);
            System.out.println(employee.getEmployeeStatus().toString());

           em.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}