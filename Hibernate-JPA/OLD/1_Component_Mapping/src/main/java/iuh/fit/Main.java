package iuh.fit;

import iuh.fit.models.Address;
import iuh.fit.models.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
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
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("mariadb");

        Faker faker = new Faker();


        try (EntityManager em = entityManagerFactory.createEntityManager()) {
            em.getTransaction().begin();

            IntStream.range(0, 10).forEach(x -> {
                Address address = new Address();
                address.setCity(faker.address().city());
                address.setZipcode(faker.address().zipCode());
                address.setStreet(faker.address().streetAddress());

                Person person = new Person();
                person.setName(faker.name().fullName());
                person.setAddress(address);

                em.persist(person);
            });


            em.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}