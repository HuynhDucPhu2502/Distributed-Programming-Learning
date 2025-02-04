package iuh.fit;

import iuh.fit.models.Guide;
import iuh.fit.models.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import net.datafaker.Faker;

import java.util.stream.IntStream;

/**
 * Admin 2/4/2025
 * ${DESCRIPTION}
 **///TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mariadb");

//        generateFakeData(emf);
        testPersistCascade(emf);
        testDeleteCascade(emf);
    }

    public static void testPersistCascade(EntityManagerFactory entityManagerFactory) {
        Faker faker = new Faker();

        try (EntityManager em = entityManagerFactory.createEntityManager()) {
            em.getTransaction().begin();

            Guide guide = new Guide();
            guide.setName(faker.name().fullName());
            guide.setSalary(faker.number().randomDouble(2, 1000, 10000));
            guide.setStaffId(faker.bothify("2025-###-???"));

            Student student = new Student();
            student.setName(faker.name().fullName());
            student.setEnrollmentId(faker.bothify("2025-???-###"));
            student.setGuide(guide);

            em.persist(student);

            em.getTransaction().commit();

        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    public static void testDeleteCascade(EntityManagerFactory entityManagerFactory) {
        try (EntityManager em = entityManagerFactory.createEntityManager()) {
            em.getTransaction().begin();

            Student student = em.find(Student.class, 1L);
            Guide guide = em.find(Guide.class, 1L);
            System.out.println("student before remove Student Entity = " + student);
            System.out.println("guide before remove Student Entity = " + guide);

            em.remove(student);

            student = em.find(Student.class, 1L);
            guide = em.find(Guide.class, 1L);
            System.out.println("student after remove Student Entity = " + student);
            System.out.println("guide after remove Student Entity = " + guide);

            em.getTransaction().commit();
        }
    }

    public static void generateFakeData(EntityManagerFactory entityManagerFactory) {
        Faker faker = new Faker();

        try (EntityManager em = entityManagerFactory.createEntityManager()) {
            em.getTransaction().begin();

            IntStream.range(0, 3).forEach(i -> {
                int numberOfStudentsPerGuide = faker.number().numberBetween(3, 5);

                Guide guide = new Guide();
                guide.setName(faker.name().fullName());
                guide.setSalary(faker.number().randomDouble(2, 1000, 10000));
                guide.setStaffId(faker.bothify("2025-###-???"));

                IntStream.range(0, numberOfStudentsPerGuide).forEach(x -> {
                    Student student = new Student();
                    student.setName(faker.name().fullName());
                    student.setEnrollmentId(faker.bothify("2025-???-###"));
                    student.setGuide(guide);

                    em.persist(student);
                });
            });

            em.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}