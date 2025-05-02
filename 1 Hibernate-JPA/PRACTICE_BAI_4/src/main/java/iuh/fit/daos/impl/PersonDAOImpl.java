package iuh.fit.daos.impl;

import iuh.fit.models.Person;
import iuh.fit.utils.JPAUtil;

import java.util.List;

/**
 * Admin 3/19/2025
 **/
public class PersonDAOImpl implements iuh.fit.daos.PersonDAO {
    @Override
    public void create(Person person) {
        try (var em = JPAUtil.getEntityManager()) {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
        }
    }

    @Override
    public Person findById(Integer id) {
        try (var em = JPAUtil.getEntityManager()) {
            return em.find(Person.class, id);
        }
    }

    @Override
    public List<Person> getAll() {
        try (var em = JPAUtil.getEntityManager()) {
            return em.createQuery("FROM Person p", Person.class).getResultList();
        }
    }

    @Override
    public void delete(Integer id) {
        var em = JPAUtil.getEntityManager();
        var transaction = em.getTransaction();

        try  {
            transaction.begin();
            Person person = em.find(Person.class, id);
            if (person != null) em.remove(person);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void update(Person newPerson) {
        var em = JPAUtil.getEntityManager();
        var transaction = em.getTransaction();

        try {
            transaction.begin();
            em.merge(newPerson);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
