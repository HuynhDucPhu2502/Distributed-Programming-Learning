package iuh.fit.dao;

import iuh.fit.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transaction;

import java.util.List;

/**
 * Admin 4/14/2025
 **/
public abstract class GenericDAO <T, ID> {
    protected EntityManager em;
    protected Class<T> clazz;

    public GenericDAO(Class<T> clazz) {
        this.em = JPAUtil.getEntityManager();
        this.clazz = clazz;
    }

    public GenericDAO(EntityManager em, Class<T> clazz) {
        this.em = em;
        this.clazz = clazz;
    }

    public T findByID(ID id) {
        return em.find(clazz, id);
    }

    public List<T> getAll() {
        return em
                .createQuery("from " + clazz.getName(), clazz)
                .getResultList();
    }

    public boolean save(T t) {
        EntityTransaction tr = em.getTransaction();

        try {
            tr.begin();
            em.persist(t);
            tr.commit();
            return true;
        } catch (Exception e) {
            if (tr.isActive()) tr.rollback();

            throw new RuntimeException(e.getMessage(),e);
        }
    }

    public boolean update(T t) {
        EntityTransaction tr = em.getTransaction();

        try {
            tr.begin();
            em.merge(t);
            tr.commit();
            return true;
        } catch (Exception e) {
            if (tr.isActive()) tr.rollback();

            throw new RuntimeException(e.getMessage(),e);
        }
    }

    public boolean remove(ID id) {
        EntityTransaction tr = em.getTransaction();

        try {
            tr.begin();
            T t = em.find(clazz, id);
            if (t != null) {
                em.remove(t);
                tr.commit();
                return true;
            }

        } catch (Exception e) {
            if (tr.isActive()) tr.rollback();

            throw new RuntimeException(e.getMessage(),e);
        }

        return false;
    }
}
