package iuh.fit.daos;

import iuh.fit.models.Person;
import iuh.fit.utils.JPAUtil;

import java.util.List;

/**
 * Admin 3/19/2025
 **/
public class PersonDAO {
    public static void save(Person person) {
        try (var em = JPAUtil.getEntityManager()) {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
        }
    }

    public static Person findById(Integer id) {
        try (var em = JPAUtil.getEntityManager()) {
            return em.find(Person.class, id);
        }
    }

    public static List<Person> getAll() {
        try (var em = JPAUtil.getEntityManager()) {
            return em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
        }
    }

    public static void delete(Integer id) {
        var em = JPAUtil.getEntityManager();
        var transaction = em.getTransaction();

        try  {
            transaction.begin();
            Person person = em.find(Person.class, id);
            if (person != null) em.remove(person);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }

    }
}
