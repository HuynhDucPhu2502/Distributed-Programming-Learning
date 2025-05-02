package iuh.fit.daos;

import iuh.fit.models.Person;

import java.rmi.Remote;
import java.util.List;

/**
 * Admin 4/9/2025
 **/
public interface PersonDAO extends Remote {
    void create(Person person);

    Person findById(Integer id);

    List<Person> getAll();

    void delete(Integer id);

    void update(Person newPerson);
}
