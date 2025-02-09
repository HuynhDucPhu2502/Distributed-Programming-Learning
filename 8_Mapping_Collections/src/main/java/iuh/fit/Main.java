package iuh.fit;

import iuh.fit.models.Address;
import iuh.fit.models.Friend;
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

        testAddFriendWithManyNicknames(emf);
    }

    private static void testAddFriendWithManyNicknames(EntityManagerFactory emf) {
        Faker faker = new Faker();

        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();

            Friend friend = new Friend();
            friend.setName(faker.name().fullName());
            friend.setEmail(faker.internet().emailAddress());
            IntStream.range(0, 3).forEach(i -> {
                friend.getNicknames().add(faker.name().title());
            });
            IntStream.range(0, 2).forEach(i -> {
                Address address = new Address();
                address.setStreet(faker.address().streetAddress());
                address.setCity(faker.address().city());
                address.setZipcode(faker.address().zipCode());
                friend.getAddresses().add(address);
            });

            em.persist(friend);

            em.getTransaction().commit();
        }
    }
}